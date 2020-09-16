package com.example.appuniversitario;

public class Habilidades {
    public String idHabilidades;
    public String descricao;

    public Habilidades(){}
    public Habilidades(String descricao)
    {
        this.descricao = descricao;

    }

    @Override
    public String toString() {
        return descricao;
    }
}
