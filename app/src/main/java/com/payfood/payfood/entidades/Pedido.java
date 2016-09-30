package com.payfood.payfood.entidades;

import lombok.Data;

@Data
public class Pedido {
    private Produto produto;
    private Estabelecimento estabelecimento;
    private Usuario usuario;
}
