package com.payfood.payfood.procurandoLanche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;

import framework.Painel;

public class PainelPedirLanche extends Painel {

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_pedir_lanche, container, false);
        return view;
    }
}
