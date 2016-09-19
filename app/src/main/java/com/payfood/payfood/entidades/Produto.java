package com.payfood.payfood.entidades;

import java.math.BigDecimal;

import minhaLang.Imagem;

public class Produto {

    public String id;
    public String nome;
    public String descricao;
    public String imgUrl;
    public BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getId() {
        return id;
    }
}
