package framework.userAccountManagement;


import android.content.Intent;

import com.payfood.payfood.entidades.Usuario;
import com.payfood.payfood.entrandoComoUsuario.TelaCadastro;

import framework.Tela;

public class VerificadorContaImpl implements VerificadorConta {
    private final Tela context;

    public VerificadorContaImpl(Tela tela) {
        this.context = tela;
    }

    @Override
    public boolean jaTemConta(Usuario usuario) {
        return false;
    }

    @Override
    public void registrar(int requestCode) {
        Intent activityCadastro = new Intent(context, TelaCadastro.class);
        context.startActivityForResult(activityCadastro, requestCode);
    }
}
