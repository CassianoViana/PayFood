package com.payfood.payfood.configuracoes.usuario.perfil;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.configuracoes.usuario.perfil.planos.TelaPlanos;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.util.FrameworkUtil;

public class TelaPerfil extends Tela {

    private TextView txtNome, txtEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_perfil);
        FrameworkUtil.setUpToolbar(this, getResources().getString(R.string.tituloPerfil));

        Usuario usuario = GerenciadorUsuario.instance(this).getUsuario();

        txtNome = (TextView) findViewById(R.id.nome);
        txtEmail = (TextView) findViewById(R.id.email);

        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());
    }

    public void onClickEditarPerfil(View view) {
        startActivity(new Intent(this, com.payfood.payfood.configuracoes.usuario.perfil.TelaEditarPerfil.class));
    }

    public void onClickAlterarPlano(View view) {
        startActivity(new Intent(this, TelaPlanos.class));
    }
}
