package com.payfood.payfood.telaPrincipal;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;
import com.payfood.payfood.configurandoMeusDados.PainelPerfil;
import com.payfood.payfood.procurandoLanche.PainelEstabelecimentos;

import framework.Painel;
import framework.Tela;

public class DashBoard extends Painel {

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Toolbar barraTopo = (Toolbar) view.findViewById(R.id.barra_topo);
        barraTopo.setTitle("TESTE");
        Tela activity = (Tela) getActivity();
        activity.setSupportActionBar(barraTopo);
        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.estabelecimentos:
                chamar(PainelEstabelecimentos.class);
                break;
            case R.id.perfil:
                chamar(PainelPerfil.class);
                break;
        }
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.barra_topo, menu);
    }
}
