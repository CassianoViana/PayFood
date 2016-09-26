package com.payfood.payfood.configuracoes.usuario.perfil;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.payfood.payfood.R;
import com.payfood.payfood.configuracoes.usuario.perfil.planos.TelaPlanos;

import framework.Tela;
import framework.util.FrameworkUtil;

public class TelaPerfil extends Tela {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_perfil);

        FrameworkUtil.setUpToolbar(this, getResources().getString(R.string.tituloPerfil));
    }

    public void onClickEditarPerfil(View view) {
        startActivity(new Intent(this, com.payfood.payfood.configuracoes.usuario.perfil.TelaEditarPerfil.class));
    }

    public void onClickAlterarPlano(View view) {
        startActivity(new Intent(this, TelaPlanos.class));
    }
}
