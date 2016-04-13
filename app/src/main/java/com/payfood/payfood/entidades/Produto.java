package com.payfood.payfood.entidades;

import minhaLang.Imagem;

public class Produto {

    private String nome;
    private String descricao;
    private Imagem imagem;
    private Categoria categoria;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
