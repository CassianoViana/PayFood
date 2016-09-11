package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entrandoComoUsuario.TelaLogin;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.PainelLanches;

import framework.Tela;

public class TelaEstabelecimento extends Tela {

    Estabelecimento estabelecimento;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_estabelecimento);

        String nome = getIntent().getStringExtra("nome");
        String id = getIntent().getStringExtra("id");
        estabelecimento = new Estabelecimento();
        estabelecimento.id = id;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(nome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PainelLanches painelLanches = new PainelLanches();
        getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_centro_tela_estabelecimento, painelLanches).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
