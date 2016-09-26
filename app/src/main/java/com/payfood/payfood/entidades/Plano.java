package com.payfood.payfood.entidades;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Plano {
    private String nome, descricao;
    private BigDecimal preco;
    private Boolean recorrente;
    private Integer duracaoEmDias;
    private List<FuncionalidadePlano> funcionalidades;

    public Plano(String nome, List<FuncionalidadePlano> funcionalidades){
        setNome(nome);
        setFuncionalidades(funcionalidades);
    }


}
