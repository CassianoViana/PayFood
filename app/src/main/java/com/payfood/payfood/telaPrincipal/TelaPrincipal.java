package com.payfood.payfood.telaPrincipal;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.payfood.payfood.R;
import com.payfood.payfood.configurandoMeusDados.PainelPerfil;
import com.payfood.payfood.conhecendoApp.PainelApresentacao;
import com.payfood.payfood.procurandoLanche.PainelEstabelecimentos;

import framework.GerenciadorTelas;
import framework.Tela;

public class TelaPrincipal extends Tela {

    @Override
    protected void aoCriar(Bundle estado) {
        setContentView(R.layout.tela_principal);
        GerenciadorTelas gerenciadorTelas = new GerenciadorTelas(getSupportFragmentManager());
        gerenciadorTelas.chamar(PainelApresentacao.class);

        Toolbar barraTopo = (Toolbar) findViewById(R.id.barra_topo);
        setSupportActionBar(barraTopo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu);
        inflater.inflate(R.menu.barra_topo, menu);
    }
}