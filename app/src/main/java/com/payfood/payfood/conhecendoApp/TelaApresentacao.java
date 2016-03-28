package com.payfood.payfood.conhecendoApp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.payfood.payfood.R;
import com.payfood.payfood.procurandoLanche.TelaPrincipal;

import framework.Tela;

public class TelaApresentacao extends Tela {

    private ViewPager pagerApresentacaoApp;

    @Override
    public void aoCriar() {
        setContentView(R.layout.activity_apresentacao);
        associarComponentes();
    }

    private void associarComponentes() {
        pagerApresentacaoApp = (ViewPager) findViewById(R.id.tabs_apresentacao_app);
        pagerApresentacaoApp.setAdapter(new AdapterPagerTelaApresentacaoApp(this).getAdapter());
    }

    public void conhecer(View view) {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
        finish();
    }
}
