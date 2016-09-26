package com.payfood.payfood.entrandoComoUsuario;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.appconstants.ResultCode;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.util.FrameworkUtil;

public class TelaCadastro extends Tela {

    private TextView txtEmail, txtUsuario, txtSenha;
    PostUsuario post;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtUsuario = (TextView) findViewById(R.id.txtUsuario);
        txtSenha = (TextView) findViewById(R.id.txtSenha);

        PostUsuarioListener listenerPost = new PostUsuarioListener();
        post = new PostUsuario(this, listenerPost);
    }

    public void onClickEconomizar(View view) {
        Usuario usuario = new Usuario();
        usuario.nome = txtUsuario.getText().toString();
        usuario.email = txtEmail.getText().toString();
        usuario.senha = txtSenha.getText().toString();
        post.salvarUsuario(usuario);
    }

    private class PostUsuarioListener implements PostUsuario.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            GerenciadorUsuario.instance(TelaCadastro.this).salvarUsuario(usuario);
            setResult(ResultCode.LOGOU);
            finish();
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(TelaCadastro.this, e);
        }
    }
}
