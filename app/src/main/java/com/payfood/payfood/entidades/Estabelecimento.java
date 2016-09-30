package com.payfood.payfood.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estabelecimento implements Serializable {
    private String nome;
    private String id;
    private String endereco;
    private String imgUrl;
    private Double latitude, longitude;
    private String descricao;
    private BigDecimal avaliacao;
    private Localizacao location;

    public Estabelecimento(String estabelecimentoId) {
        setId(estabelecimentoId);
    }

    public Estabelecimento() {
    }

    public void setAvaliacaoDouble(double avaliacao) {
        setAvaliacao(new BigDecimal(avaliacao).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}