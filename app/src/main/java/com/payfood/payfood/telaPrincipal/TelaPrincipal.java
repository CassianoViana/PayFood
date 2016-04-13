package com.payfood.payfood.telaPrincipal;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.payfood.payfood.R;
import com.payfood.payfood.configurandoMeusDados.PainelPerfil;
import com.payfood.payfood.procurandoLanche.PainelEstabelecimentos;

import framework.ListenerSolicitacaoAbrirOutraTela;
import framework.Painel;
import framework.PainelNull;
import framework.Tela;

public class TelaPrincipal extends Tela {

    private static final String TAG = TelaPrincipal.class.getSimpleName();
    private Toolbar barraFerramentas;
    private ListenerSolicitacaoAbrirOutraTela gerenciadorFragments;

    @Override
    protected void aoCriar(Bundle estado) {
        setContentView(R.layout.tela_principal);
        obterComponentesDoLayout();
        configurarToolbar();
        iniciarGerenciadorFragments();
    }

    private void iniciarGerenciadorFragments() {
        gerenciadorFragments = new GerenciadorFragments(getSupportFragmentManager());
    }

    private void obterComponentesDoLayout() {
        barraFerramentas = (Toolbar) findViewById(R.id.barra_topo);
    }

    private void configurarToolbar() {
        setSupportActionBar(barraFerramentas);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        Painel painel = new PainelNull();
        switch (item.getItemId()){
            case R.id.estabelecimentos:
                painel = new PainelEstabelecimentos();
                break;
            case R.id.perfil:
                painel = new PainelPerfil();
                break;
        }
        gerenciadorFragments.mostrar(painel);
        Log.d(TAG, item.toString());
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barra_topo, menu);
        return true;
    }
}