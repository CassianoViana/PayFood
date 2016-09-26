package com.payfood.payfood.configuracoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import framework.Painel;

import static com.payfood.payfood.R.layout.fragment_perfil_edicao;

public class PainelEdicaoPerfil extends Painel {
    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(fragment_perfil_edicao, container, false);
        return view;
    }
}
