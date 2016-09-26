package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entidades.Produto;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche.TelaLanche;

import java.util.Map;

import framework.Painel;

public class PainelLanches extends Painel implements ListaLanches.Listener {

    private static PainelLanches painelLanches;
    private ListaLanches listaLanches;
    private Listener listener;

    public static PainelLanches instance(Listener listener) {
        if (painelLanches == null) {
            painelLanches = new PainelLanches();
        }
        painelLanches.listener = listener;
        return painelLanches;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lanches, container, false);
        listaLanches = new ListaLanches(view, this);
        listener.pronto();
        return view;
    }

    public void carregarLanches(Estabelecimento estabelecimento) {
        listaLanches.carregar(estabelecimento);
    }

    @Override
    public void aoListaLanchesCarregar() {
        listener.carregou();
    }

    @Override
    public void aoListaLanchesTerErro(Throwable erro) {
        listener.erro(erro);
    }

    @Override
    public void aoClicarEmProdutoDaLista(Produto produto) {
        Intent intent = new Intent(getActivity(), TelaLanche.class);
        intent.putExtra("produto", produto);
        getActivity().startActivity(intent);
    }

    public interface Listener {
        void carregou();
        void erro(Throwable problema);
        void pronto();
    }
}
