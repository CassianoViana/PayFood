package com.payfood.payfood.entrandoComoUsuario;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.appconstants.ResultCode;
import com.payfood.payfood.crudContract.UsuarioSaver;
import com.payfood.payfood.crudContract.impl.UsuarioSaverImpl;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.util.FrameworkUtil;

public class TelaCadastro extends Tela {

    private TextView txtEmail, txtUsuario, txtSenha;
    UsuarioSaver saver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        txtSenha = (TextView) findViewById(R.id.txtSenha);

        saver = new UsuarioSaverImpl();
        saver.construct(this, new PostUsuarioListener());
    }

    public void onClickEconomizar(View view) {
        Usuario usuario = new Usuario();
        usuario.setNome(txtUsuario.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        saver.save(usuario);
    }

    private class PostUsuarioListener implements UsuarioSaver.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            setResult(ResultCode.LOGOU);
            GerenciadorUsuario.instance(TelaCadastro.this).persist(usuario);
            finish();
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(TelaCadastro.this, e);
        }
    }
}
