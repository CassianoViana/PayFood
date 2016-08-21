package com.payfood.payfood.procurandoLanche.estabelecimento;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cassiano on 20/08/16.
 */
public class ListaEstabelecimentos implements CarregadorEstabelecimentos.Listener{

    List<Estabelecimento> estabelecimentos;
    TextView loader;
    RecyclerView listaEstabelecimentos;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager mLayoutManager;
    CarregadorEstabelecimentos carregadorEstabelecimentos;

    public ListaEstabelecimentos(View view) {
        loader = (TextView) view.findViewById(R.id.loader);
        estabelecimentos = new ArrayList<>();
        listaEstabelecimentos = (RecyclerView) view.findViewById(R.id.lista_estabelecimentos);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        listaEstabelecimentos.setLayoutManager(mLayoutManager);
        adapter = new ListaEstabelecimentosAdapter(estabelecimentos);
        listaEstabelecimentos.setAdapter(adapter);

        carregadorEstabelecimentos = new CarregadorEstabelecimentos(this);
        carregadorEstabelecimentos.carregar(estabelecimentos);
    }

    @Override
    public void carregou() {
        loader.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void falhou(int statusCode, JSONObject errorResponse) {
        loader.setText(String.valueOf(statusCode));
    }
}
