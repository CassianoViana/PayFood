package com.payfood.payfood.crudContract;

import android.content.Context;

import com.payfood.payfood.entidades.Usuario;

public interface UsuarioSaver {

    void construct(Context context, Listener listener);
    void save(Usuario usuario);

    interface Listener {
        void sucesso(Usuario usuario);
        void erro(Throwable e);
    }
}
