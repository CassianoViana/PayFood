package com.payfood.payfood.telaPrincipal;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.payfood.payfood.R;

import java.util.HashMap;
import java.util.Map;

import framework.ListenerSolicitacaoAbrirOutraTela;
import framework.Painel;

public class GerenciadorFragments implements ListenerSolicitacaoAbrirOutraTela {

    private FragmentManager fragmentManager;
    private Map<String, Painel> mapa;

    public GerenciadorFragments(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.mapa = new HashMap<>();
    }

    @Override
    public void mostrar(Painel painel) {

        painel.addListenerSolicitacaoAbrirOutraTela(this);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        String key = painel.getClass().getName();
        boolean chaveExiste = mapa.containsKey(key);
        if (!chaveExiste) {
            mapa.put(key, painel);
        } else {
            painel = mapa.get(key);
        }
        ft.replace(R.id.conteudo, painel);
        if(!chaveExiste) {
            ft.addToBackStack(key);
        }
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }
}
