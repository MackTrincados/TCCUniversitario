package com.example.appuniversitario;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appuniversitario.Models.FeedActivityOfi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity {


    private EditText txtSobre, txtEmail, txtCelular, txtSemestre, txtSexo;
    private TextView txtCurso;
    private EditText txtNome;
    private Button btnSalvarPerfil, btnHabilidades;
    private CircleImageView imagemUsuarioPerfil;
    ImageView imgUsuarioPerfil;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    StorageReference storageReference;

    String IdPerfil = "";
    public String a = "";
    public Usuarios usu = new Usuarios();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil1);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        IdPerfil = firebaseAuth.getUid();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileref = storageReference.child("users/" + firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        profileref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(imgUsuarioPerfil);
            }
        });


        int c = 1;
        EventoDataBase();

        txtNome = (EditText) findViewById(R.id.txtNomeUsuPer);
        txtSobre = (EditText) findViewById(R.id.txtSobreMimPerfil);
        txtEmail = (EditText) findViewById(R.id.txtEmailPerfil);
        txtCelular = (EditText) findViewById(R.id.txtCelularPerfil);
        //txtSexo = (EditText) findViewById(R.id.txtSexoPerfil);
        txtCurso = (EditText) findViewById(R.id.txtCursoPerfil);
        txtSemestre = (EditText) findViewById(R.id.txtSemestrePerfil);
        //btnSalvarPerfil = (Button) findViewById(R.id.btnSalvarPerfil);
        btnHabilidades = (Button) findViewById(R.id.btnHabilidades);
        //btnSalvarPerfil.setOnClickListener(new View.OnClickListener()
        imgUsuarioPerfil = findViewById(R.id.imgUsuarioPerfil);
        imagemUsuarioPerfil = (CircleImageView) findViewById(R.id.imgUsuarioPerfil);

        btnHabilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HabilidadesActivity.class));
            }
        });

        imgUsuarioPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //open gallery
                Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(openGalleryIntent, 1000);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                //imgUsuarioPerfil.setImageURI(imageUri);

                uploadImageToFirebase(imageUri);

            }
        }
    }

    private void uploadImageToFirebase(Uri imageUri) {
        //upload image to firebase storage

        final StorageReference fileRef = storageReference.child("users/" + firebaseAuth.getCurrentUser().getUid()+"/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(imgUsuarioPerfil);
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(PerfilActivity.this, "Failed.", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void EventoDataBase() {
        {

            databaseReference.child("Usuarios").child(IdPerfil).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Usuarios usuarios = snapshot.getValue(Usuarios.class);
                    usu = snapshot.getValue(Usuarios.class);
                    txtNome.setText(usuarios.nome);
                    txtEmail.setText(usuarios.email);
                    //txtSobre.setText(usuarios.sobrenome);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
    }
}