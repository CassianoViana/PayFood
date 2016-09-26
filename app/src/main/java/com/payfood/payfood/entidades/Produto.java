package com.payfood.payfood.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import minhaLang.Imagem;

public class Produto implements Serializable {

    public String id;
    public String nome;
    public String descricao;
    public String imgUrl;
    public BigDecimal preco;
    public String estabelecimentoId;
    public Estabelecimento estabelecimento;

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

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setId(String id) {
        this.id = id;
    }
}
