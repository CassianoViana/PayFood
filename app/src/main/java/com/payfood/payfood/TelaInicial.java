package com.payfood.payfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.payfood.payfood.entrandoComoUsuario.TelaAcessarConta;
import com.payfood.payfood.telaPrincipal.TelaPrincipal;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;

public class TelaInicial extends Tela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        if (GerenciadorUsuario.instance(this).estaLogado())
            startActivity(new Intent(this, TelaPrincipal.class));
    }

    public void onClickConhecer(View view) {
        startActivity(new Intent(this, TelaPrincipal.class));
    }

    public void onClickAcessarConta(View view) { startActivity(new Intent(this, TelaAcessarConta.class)); }
}
