package com.payfood.payfood.entidades;

import minhaLang.Data;
import minhaLang.Imagem;

public class Usuario {
    public String nome, email, telefone, senha;
    private Imagem imagem;
    private Data dataRegistro;
    private DadosBancarios dadosBancarios;
    private Inscricao inscricao;


    public String getEmail() {
        return email;
    }
}
