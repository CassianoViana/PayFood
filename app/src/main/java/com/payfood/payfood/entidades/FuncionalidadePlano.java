package com.payfood.payfood.entidades;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionalidadePlano {
    private String descricao;
    private  Boolean disponivel;

    public FuncionalidadePlano(String descricao, Boolean disponivel){
        setDescricao(descricao);
        setDisponivel(disponivel);
    }

}
