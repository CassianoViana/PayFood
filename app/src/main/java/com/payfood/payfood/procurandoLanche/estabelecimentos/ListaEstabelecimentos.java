package com.payfood.payfood.procurandoLanche.estabelecimentos;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;

import java.util.ArrayList;
import java.util.List;

public class ListaEstabelecimentos implements CarregadorEstabelecimentos.Listener, ListaEstabelecimentosAdapter.Listener {

    List<Estabelecimento> estabelecimentos;
    TextView loader;
    RecyclerView listaEstabelecimentos;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    CarregadorEstabelecimentos carregadorEstabelecimentos;
    BarraProgresso barraProgresso;
    Listener listener;

    public ListaEstabelecimentos(View viewParent, Listener listener) {
        this.listener = listener;

        loader = (TextView) viewParent.findViewById(R.id.loader);
        barraProgresso = new BarraProgresso(viewParent);

        estabelecimentos = new ArrayList<>();
        listaEstabelecimentos = (RecyclerView) viewParent.findViewById(R.id.lista_estabelecimentos);
        mLayoutManager = new LinearLayoutManager(viewParent.getContext());
        listaEstabelecimentos.setLayoutManager(mLayoutManager);
        adapter = new ListaEstabelecimentosAdapter(estabelecimentos, viewParent.getContext(), this);
        listaEstabelecimentos.setAdapter(adapter);

        carregadorEstabelecimentos = new CarregadorEstabelecimentos(this);
        carregarEstabelecimentos();
    }

    public void carregarEstabelecimentos() {
        barraProgresso.zerar();
        estabelecimentos.clear();
        carregadorEstabelecimentos.carregar(estabelecimentos);
    }

    @Override
    public void carregadorTerminou() {
        loader.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
        listener.onListaPronta();
    }

    @Override
    public void carregadorFalhou(int statusCode, Throwable error) {
        listener.onListaPronta();
        estabelecimentos.clear();
        loader.setVisibility(View.VISIBLE);
        loader.setText(error.getLocalizedMessage() + " (" + statusCode + ")");
    }

    @Override
    public void carregadorProgrediu(double done, long total) {
        barraProgresso.progresso(done, total);
    }

    @Override
    public void itemAdapterFoiClicado(Estabelecimento estabelecimento) {
        listener.itemDaListaFoiClicado(estabelecimento);
    }

    public interface Listener {
        void onListaPronta();
        void itemDaListaFoiClicado(Estabelecimento estabelecimento);
    }
}
