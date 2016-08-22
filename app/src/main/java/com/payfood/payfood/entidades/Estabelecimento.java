package com.payfood.payfood.entidades;

public class Estabelecimento {
    public String nome;
    public int id;
    public String endereco;
    public String imgUrl;
    public Double latitude, longitude;
    public String descricao;
    public int avaliacao;

    public Estabelecimento() {

    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getImgUrl(){ return imgUrl; }

    public String getDescricao() { return descricao; }

    public int getAvaliacao() {
        return avaliacao;
    }

    public int getId() {
        return id;
    }
}
