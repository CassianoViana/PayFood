package com.payfood.payfood.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

public class Estabelecimento implements Serializable {
    public String nome;
    public String id;
    public String endereco;
    public String imgUrl;
    public Double latitude, longitude;
    public String descricao;
    public BigDecimal avaliacao;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = new BigDecimal(avaliacao).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getAvaliacao() {
        return avaliacao;
    }
}