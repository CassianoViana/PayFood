package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;

import java.util.HashMap;
import java.util.Map;

import framework.Painel;

public class PainelLanches extends Painel implements ListaLanches.Listener {

    private ListaLanches listaLanches;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lanches, container, false);
        listaLanches = new ListaLanches(view, this);
        carregarLanches();
        return view;
    }

    private void carregarLanches() {
        Map<String, Object> filtros = new HashMap<>();

        Intent intent = getActivity().getIntent();
        filtros.put("estab_id", intent.getStringExtra("id"));

        listaLanches.carregar(filtros);
    }

    @Override
    public void carregou() {

    }

    @Override
    public void deuPau(String erro) {

    }
}
