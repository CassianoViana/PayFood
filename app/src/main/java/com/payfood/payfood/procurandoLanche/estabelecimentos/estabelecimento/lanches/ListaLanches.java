package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.payfood.payfood.R;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.entidades.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListaLanches implements Carregador.Listener, ListaLanchesAdapter.Listener {

    List<Produto> lanches;
    Listener listener;
    RecyclerView listView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager recyclerLayoutManager;
    CarregadorLanches carregadorLanches;

    public ListaLanches(View view, Listener listener) {
        this.listener = listener;

        lanches = new ArrayList<>();
        listView = (RecyclerView) view.findViewById(R.id.lista_produtos);
        recyclerLayoutManager = new LinearLayoutManager(view.getContext());
        listView.setLayoutManager(recyclerLayoutManager);
        adapter = new ListaLanchesAdapter(lanches, view.getContext(), this);
        listView.setAdapter(adapter);

        carregadorLanches = new CarregadorLanches(this);
    }

    @Override
    public void carregadorTerminou() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void carregadorFalhou(int statusCode, Throwable error) {

    }

    @Override
    public void carregadorProgrediu(double done, long total) {

    }

    public void carregar(Map<String, Object> filtros) {
        carregadorLanches.carregar(lanches, filtros);
    }

    @Override
    public void clicouEmProduto(Produto produto) {

    }

    public interface Listener {
        void carregou();
        void deuPau(String erro);
    }
}
