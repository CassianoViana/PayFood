package com.payfood.payfood.procurandoLanche;

import com.payfood.payfood.entidades.Lanchonete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import minhaLang.CarregadorDados;

public class CarregadorLanchonetesTeste implements CarregadorDados<Lanchonete> {
    @Override
    public Collection<Lanchonete> getDados() {
        Lanchonete[] lanchonetes = {
                new Lanchonete("Lanchonete e Restaurante Tomio", "R. Cel. Aristiliano Ramos, 390"),
                new Lanchonete("Cardápios Bnu Lanches Blumenau", "Garcia, Blumenau SC - R. Amazonas"),
                new Lanchonete("Lanchonete Restaurante La Terra", "4,7 (18) · Restaurante"),
                new Lanchonete("Lanchonete do Pedro", "Rua Uruguai")
        };
        ArrayList<Lanchonete> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, lanchonetes);
        return arrayList;
    }
}
