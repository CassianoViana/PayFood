package com.payfood.payfood.conhecendoApp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

import framework.Tela;

public class AdapterPagerTelaApresentacaoApp {

    private PagerAdapter adapter;
    List<PainelImagem> paineis;

    public AdapterPagerTelaApresentacaoApp(Tela tela) {
        super();
        paineis = new ArrayList<>();
        paineis.add(new PainelImagem());
        paineis.add(new PainelImagem());
        paineis.add(new PainelImagem());
        criarAdapter(tela);
    }

    private void criarAdapter(final Tela tela) {
        adapter = new FragmentPagerAdapter(tela.getSupportFragmentManager()) {

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
