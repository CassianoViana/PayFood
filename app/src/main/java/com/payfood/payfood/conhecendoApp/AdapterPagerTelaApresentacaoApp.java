package com.payfood.payfood.conhecendoApp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

import com.payfood.payfood.R;

import java.util.ArrayList;
import java.util.List;

import framework.Painel;
import framework.Tela;

public class AdapterPagerTelaApresentacaoApp {

    private PagerAdapter adapter;
    List<PainelImagem> paineis;

    public AdapterPagerTelaApresentacaoApp(Painel tela) {
        super();
        paineis = new ArrayList<>();
        paineis.add(PainelImagem.criar(R.drawable.coxinha));
        paineis.add(PainelImagem.criar(R.drawable.painel1));
        paineis.add(PainelImagem.criar(R.drawable.coxinha));
        criarAdapter(tela);
    }

    private void criarAdapter(final Painel tela) {
        adapter = new FragmentPagerAdapter(tela.getActivity().getSupportFragmentManager()) {

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
