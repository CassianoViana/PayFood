package com.payfood.payfood.procurandoLanche.estabelecimentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.TelaEstabelecimento;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.PainelLanches;

import framework.Painel;

public class PainelEstabelecimentos extends Painel implements SwipeRefreshEstabelecimentos.Listener, ListaEstabelecimentos.Listener {

    ListaEstabelecimentos listaEstabelecimentos;
    SwipeRefreshEstabelecimentos swipeRefreshEstabelecimentos;

    public PainelEstabelecimentos() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estabelecimentos, container, false);
        listaEstabelecimentos = new ListaEstabelecimentos(view, this);
        swipeRefreshEstabelecimentos = new SwipeRefreshEstabelecimentos(view, this);
        return view;
    }

    @Override
    public void onSwipeRefresh() {
        listaEstabelecimentos.carregarEstabelecimentos();
    }

    @Override
    public void onListaPronta() {
        swipeRefreshEstabelecimentos.stopRefresh();
    }

    @Override
    public void itemDaListaFoiClicado(Estabelecimento estabelecimento) {
        Intent intent = new Intent(getContext(), TelaEstabelecimento.class);
        intent.putExtra("nome", estabelecimento.getNome());
        intent.putExtra("id", estabelecimento.getId());
        startActivity(intent);
    }
}
