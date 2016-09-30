package com.payfood.payfood.crudContract.mock.successMock;

import android.content.Context;

import com.payfood.payfood.crudContract.UsuarioSaver;
import com.payfood.payfood.entidades.Usuario;

public class UsuarioSaverImplSuccess implements UsuarioSaver {
    private Listener listener;

    @Override
    public void save(Usuario usuario) {
        listener.sucesso(usuario);
    }

    @Override
    public void construct(Context context, Listener listener) {
        this.listener = listener;
    }
}
