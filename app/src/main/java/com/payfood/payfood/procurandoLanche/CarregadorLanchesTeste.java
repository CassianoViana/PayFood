package com.payfood.payfood.procurandoLanche;

import com.payfood.payfood.entidades.Produto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import minhaLang.CarregadorDados;

public class CarregadorLanchesTeste  implements CarregadorDados<Produto> {
    @Override
    public Collection<Produto> getDados() {
        Produto[] lanchonetes = {
                new Produto("Pastel", "R$ 4.75"),
                new Produto("Coxinha", "R$ 3,70"),
                new Produto("Cachorro Quente", "R$ 12,99"),
                new Produto("Suco de Laranja + Pastel", "R$ 10,90"),
                new Produto("Pastel", "R$ 4.75"),
                new Produto("Coxinha", "R$ 3,70"),
                new Produto("Cachorro Quente", "R$ 12,99"),
                new Produto("Suco de Laranja + Pastel", "R$ 10,90")
        };
        ArrayList<Produto> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, lanchonetes);
        return arrayList;
    }
}
