package com.payfood.payfood.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosBancarios {
    String nomeCartao, codigo;
    Integer digitoVerificador;
}
