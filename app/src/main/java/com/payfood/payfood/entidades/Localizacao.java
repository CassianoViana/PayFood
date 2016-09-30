package com.payfood.payfood.entidades;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Localizacao implements Serializable {
    private double x, y;

    public Localizacao(Double x, Double y) {
        setX(x);
        setY(y);
    }
}
