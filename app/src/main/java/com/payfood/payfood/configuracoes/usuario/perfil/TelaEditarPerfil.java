package com.payfood.payfood.configuracoes.usuario.perfil;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.crudContract.UsuarioSaver;
import com.payfood.payfood.crudContract.impl.UsuarioSaverImpl;
import com.payfood.payfood.crudContract.mock.failMock.UsuarioSaverImplFail;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.util.FrameworkUtil;

public class TelaEditarPerfil extends Tela {

    private EditText edtNome, edtEmail, edtPhone, edtSenha;
    private UsuarioSaver usuarioSaver;
    private Usuario usuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_editar_perfil);

        edtNome = (EditText) findViewById(R.id.editNome);
        edtEmail = (EditText) findViewById(R.id.editEmail);
        edtSenha = (EditText) findViewById(R.id.editSenha);
        edtPhone = (EditText) findViewById(R.id.editTelefone);

        usuarioSaver = new UsuarioSaverImpl();
        usuarioSaver.construct(this, new UsuarioSaverListener());

        usuario = GerenciadorUsuario.instance(this).getUsuario();

        edtNome.setText(usuario.getNome());
        edtEmail.setText(usuario.getEmail());

        FrameworkUtil.setUpToolbar(this, getResources().getString(R.string.editar_perfil));
    }

    public void onClickConcluir(View view) {
        usuario.setNome(edtNome.getText().toString());
        usuario.setEmail(edtEmail.getText().toString());
        usuario.setSenha(edtSenha.getText().toString());
        usuario.setTelefone(edtPhone.getText().toString());
        usuarioSaver.save(usuario);
    }

    private class UsuarioSaverListener implements UsuarioSaver.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            GerenciadorUsuario.instance(TelaEditarPerfil.this).persist(usuario);
            finish();
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(TelaEditarPerfil.this, e);
        }
    }
}
