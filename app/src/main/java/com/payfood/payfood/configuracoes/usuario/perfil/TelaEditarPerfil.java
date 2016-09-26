package com.payfood.payfood.configuracoes.usuario.perfil;


import android.os.Bundle;
import android.view.View;

import com.payfood.payfood.R;

import framework.Tela;
import framework.util.FrameworkUtil;

public class TelaEditarPerfil extends Tela {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_editar_perfil);

        FrameworkUtil.setUpToolbar(this, getResources().getString(R.string.editar_perfil));
    }

    public void onClickConcluir(View view) {
        finish();
    }
}
