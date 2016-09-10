package com.payfood.payfood.entidades;

import java.math.BigDecimal;

public class Estabelecimento {
    public String nome;
    public String id;
    public String endereco;
    public String imgUrl;
    public Double latitude, longitude;
    public String descricao;
    public BigDecimal avaliacao;

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

    public BigDecimal getAvaliacao() {
        return avaliacao;
    }

    public String getId() {
        return id;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = new BigDecimal(avaliacao).setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}