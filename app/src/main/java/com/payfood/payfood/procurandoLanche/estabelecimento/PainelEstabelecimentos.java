package com.payfood.payfood.procurandoLanche.estabelecimento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;

import framework.Painel;

public class PainelEstabelecimentos extends Painel {

    private ListaEstabelecimentos listaEstabelecimentos;

    public PainelEstabelecimentos() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estabelecimentos, container, false);
        listaEstabelecimentos = new ListaEstabelecimentos(view);
        return view;
    }
}
