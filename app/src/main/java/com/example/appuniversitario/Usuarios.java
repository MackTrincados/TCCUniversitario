package com.example.appuniversitario;

import android.widget.ImageView;

public class Usuarios {
    public String idUsuarios;
    public String nome;
    public String email;
    public String senha;
    public String sobrenome;
    public ImageView fotodeperfil;
    public String sobremim;
    public String telefone;
    public String sexo;
    public int semestre;

    public  Usuarios(){}
    public  Usuarios(String nome,String email,String sobrenome,String senha, ImageView fotodeperfil)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.fotodeperfil = fotodeperfil;
    }


}
