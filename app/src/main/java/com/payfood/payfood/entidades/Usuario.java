package com.payfood.payfood.entidades;

import lombok.Getter;
import lombok.Setter;
import minhaLang.Data;
import minhaLang.Imagem;

@Getter
@Setter
public class Usuario {
    public static Usuario NULL = new Usuario(){};
    private String nome, email, telefone, senha;
    private Imagem imagem;
    private Data dataRegistro;
    private DadosBancarios dadosBancarios;
    private Inscricao inscricao;
    private String id;
}
