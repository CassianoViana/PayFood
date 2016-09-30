package com.payfood.payfood.crudContract;

import android.content.Context;

import com.payfood.payfood.entidades.Usuario;

public interface LoginPost {

    void construct(Context context, Listener listener);
    void logar(Usuario usuario);

    interface Listener{
        void sucesso(Usuario usuario);
        void erro(Throwable e);
    }
}
