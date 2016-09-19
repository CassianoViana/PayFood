package com.payfood.payfood.entrandoComoUsuario;

import android.os.Bundle;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;

public class TelaCadastro extends Tela {

    PainelCadastro painelCadastro;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        painelCadastro = new PainelCadastro();
        painelCadastro.setListener(new PainelCadastroListener());
        getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_centro_tela_cadastro, painelCadastro).commit();
    }

    private class PainelCadastroListener implements PainelCadastro.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            GerenciadorUsuario.instance(TelaCadastro.this).salvarUsuario(usuario);
            setResult(REQUEST_CODE_LOGAR);
            finish();
        }
    }
}
