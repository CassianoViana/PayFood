package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.PainelLanches;

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

        estabelecimento = (Estabelecimento) getIntent().getSerializableExtra("estabelecimento");
        FrameworkUtil.setUpToolbar(this, estabelecimento.getNome());

        mostrarPainelLanches();
    }

    private void mostrarPainelLanches() {
        PainelLanches.Listener listener = new PainelLanchesListener();
        painelLanches = PainelLanches.instance(listener);
        mostrar(painelLanches);
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
            painelLanches.carregarLanches(estabelecimento);
        }
    }
}
