/*package com.example.appuniversitario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appuniversitario.Adapters.PostAdapter;
import com.example.appuniversitario.Models.PostItem;


import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    TextView tv_uname, tv_greeting;
    EditText et_searchBar;

    RecyclerView postRecyclerView;

    PostAdapter postAdapter;

    // post recycler view
    String[] img_post;
    int[] img_display;
    String[] txt_name;
    String[] txt_time;

    private List<PostItem> postListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);

        tv_uname = (TextView) findViewById(R.id.textView_username);
        tv_greeting = (TextView) findViewById(R.id.textView_greeting);
        et_searchBar = (EditText) findViewById(R.id.editText_searchBar);

        txt_name = getResources().getStringArray(R.array.alunos);
        img_post = getResources().getStringArray(R.array.descricao);
        txt_time = getResources().getStringArray(R.array.Materias2);

        initializePosts();
        getPosts();

    }

    private void initializePosts(){

        postRecyclerView = findViewById(R.id.recyclerView);
        postRecyclerView.setHasFixedSize(true);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getPosts() {

        img_post = new String[]{"AAAAAAAAAAA","AAAAAAAAAAA","AAAAAAAAAAA","AAAAAAAAAAA","AAAAAAAAAAA","AAAAAAAAAAA"};
        img_display = new int[]{R.drawable.download, R.drawable.download2, R.drawable.download3, R.drawable.download4, R.drawable.download5, R.drawable.ftney};
        txt_name = new String[]{"Menino Ney", "Adulto Ney", "Adolescente Ney", "Ancião Ney", "Criança Ney", "Pré-adolescente Ney"};
        txt_time = new String[]{"Calculo", "Ciencia de dados", "kkk", "bbb", "ccc", "ddd"};

        for (int i = 0; i < img_post.length; i++) {
            PostItem postItem = new PostItem(img_post[i],
                    img_display[i],
                    txt_name[i],
                    txt_time[i]);

            postListItems.add(postItem);
        }


        postAdapter = new PostAdapter(postListItems, this);
        postRecyclerView.setAdapter(postAdapter);

    }
}
 */