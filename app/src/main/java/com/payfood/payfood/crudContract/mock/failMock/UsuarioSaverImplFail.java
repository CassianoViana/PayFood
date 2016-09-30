package com.payfood.payfood.crudContract.mock.failMock;

import android.content.Context;

import com.payfood.payfood.crudContract.UsuarioSaver;
import com.payfood.payfood.entidades.Usuario;

public class UsuarioSaverImplFail implements UsuarioSaver {
    private Listener listener;

    @Override
    public void save(Usuario usuario) {
        listener.erro(new Throwable("Falha ao cadastrar usuário"));
    }

    @Override
    public void construct(Context context, Listener listener) {
        this.listener = listener;
    }
}
