package com.payfood.payfood.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import minhaLang.Imagem;
import minhaLang.Util;

@Getter
@Setter
public class Produto implements Serializable {
    private String id;
    private String nome;
    private String descricao;
    private String imgUrl;
    private BigDecimal preco;
    private Estabelecimento estabelecimento;

    public String getPrecoFormatado() {
        return Util.getFormattedPrice(getPreco());
    }
}
