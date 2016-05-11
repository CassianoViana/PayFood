package com.payfood.payfood.conhecendoApp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.payfood.payfood.R;
import com.payfood.payfood.entrandoComoUsuario.TelaValidacao;
import com.payfood.payfood.telaPrincipal.TelaPrincipal;

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
        Intent telaPrincipal = new Intent(this, TelaPrincipal.class);
        startActivity(telaPrincipal);
        finish();
    }

    public void entrar(View view){
        Intent telaValidacao = new Intent(this, TelaValidacao.class);
        startActivity(telaValidacao);
        finish();
    }
}
