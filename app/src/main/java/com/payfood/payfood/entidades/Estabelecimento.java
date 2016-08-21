package com.payfood.payfood.entidades;

public class Estabelecimento {
    public String nome;
    public int id;
    public String endereco;
    Double latitude, longitude;


    public Estabelecimento(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public Estabelecimento() {

    }

    public String getNome() {
        return nome;
    }


    public String getEndereco() {
        return endereco;
    }
}
