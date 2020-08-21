package com.example.appuniversitario;

public class Usuarios {
    public String idUsuarios;
    public String nome;
    public String email;
    public String senha;
    public String sobrenome;
    public  Usuarios(){}
    public  Usuarios(String nome,String email,String sobrenome,String senha)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
    }


}
