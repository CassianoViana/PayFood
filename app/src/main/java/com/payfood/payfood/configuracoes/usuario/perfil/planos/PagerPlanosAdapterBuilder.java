package com.payfood.payfood.configuracoes.usuario.perfil.planos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Plano;

import java.util.ArrayList;
import java.util.List;

import framework.Painel;
import framework.Tela;

public class PagerPlanosAdapterBuilder {

    private final Tela context;
    private PagerAdapter adapter;
    List<Painel> paineis;

    public PagerPlanosAdapterBuilder(Tela context, List<Plano> planos) {
        super();
        this.context = context;
        paineis = new ArrayList<>();

        for (Plano plano : planos)
            paineis.add(PainelPlano.criar(plano));

        criarAdapter();
    }

    private void criarAdapter() {
        adapter = new FragmentPagerAdapter(context.getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return paineis.get(position);
            }

            @Override
            public int getCount() {
                return paineis.size();
            }
        };
    }

    public PagerAdapter getAdapter() {
        return adapter;
    }
}
