package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.PainelLanches;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche.TelaLanche;

import java.util.HashMap;
import java.util.Map;

import framework.util.FrameworkUtil;
import framework.Painel;
import framework.Tela;

public class TelaEstabelecimento extends Tela {

    public static final String TAG = TelaEstabelecimento.class.getSimpleName();
    Estabelecimento estabelecimento;
    PainelLanches painelLanches;

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

        carregarLanches();
    }

    private void carregarLanches() {
        PainelLanches.Listener listener = new PainelLanchesListener();
        painelLanches = PainelLanches.instance(listener);
        mostrar(painelLanches);
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

    private void mostrar(Painel fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_centro_tela_estabelecimento, fragment).commit();
    }

    private class PainelLanchesListener implements PainelLanches.Listener {
        @Override
        public void carregou() {
            Log.i(TAG, "Lanches carregados");
        }

        @Override
        public void erro(Throwable problema) {
            FrameworkUtil.instance().manipularErro(TelaEstabelecimento.this, problema);
        }

        @Override
        public void pronto() {
            Map<String, Object> filtros = new HashMap<>();
            Intent intent = getIntent();
            filtros.put("estab_id", intent.getStringExtra("id"));
            painelLanches.carregarLanches(filtros);
        }
    }
}
