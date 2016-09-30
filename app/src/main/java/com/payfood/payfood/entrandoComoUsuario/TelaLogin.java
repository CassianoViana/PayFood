package com.payfood.payfood.entrandoComoUsuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.crudContract.LoginPost;
import com.payfood.payfood.crudContract.impl.LoginPostImpl;
import com.payfood.payfood.entidades.Usuario;
import com.payfood.payfood.telaPrincipal.TelaPrincipal;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.util.FrameworkUtil;

public class TelaLogin extends Tela {

    TextView txtEmail, txtSenha;
    LoginPost loginPost;
    Usuario usuario;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_acessar_conta);

        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSenha = (TextView) findViewById(R.id.txtSenha);

        usuario = GerenciadorUsuario.instance(this).getUsuario();
        txtEmail.setText(usuario.getEmail());
        txtSenha.setText(usuario.getSenha());

        loginPost = new LoginPostImpl();
        loginPost.construct(this, new LoginPostListener());
    }

    public void onClickRecuperarSenha(View view) {
        startActivity(new Intent(this, TelaRecuperarSenha.class));
    }

    public void onClickEntrar(View view) {
        usuario.setEmail(txtEmail.getText().toString());
        usuario.setSenha(txtSenha.getText().toString());
        loginPost.logar(usuario);
    }

    private class LoginPostListener implements LoginPost.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            GerenciadorUsuario.instance(TelaLogin.this).persist(usuario);
            startActivity(new Intent(TelaLogin.this, TelaPrincipal.class));
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(TelaLogin.this, e);
        }
    }
}
