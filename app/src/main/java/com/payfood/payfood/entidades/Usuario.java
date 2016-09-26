package com.payfood.payfood.entidades;

import minhaLang.Data;
import minhaLang.Imagem;

public class Usuario {
    public static Usuario NULL = new Usuario();
    public String nome, email, telefone, senha;
    private Imagem imagem;
    private Data dataRegistro;
    private DadosBancarios dadosBancarios;
    private Inscricao inscricao;
    private String id;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
