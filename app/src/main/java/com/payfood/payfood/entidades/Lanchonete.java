package com.payfood.payfood.entidades;

public class Lanchonete {
    String nome, endereco;
    Double latitude, longitude;

    public Lanchonete(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }


    public String getEndereco() {
        return endereco;
    }
}
