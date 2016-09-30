package com.payfood.payfood.crudContract.mock.failMock;

import android.content.Context;

import com.payfood.payfood.crudContract.LoginPost;
import com.payfood.payfood.entidades.Usuario;

public class LoginPostImplFail implements LoginPost {
    private Context context;
    private Listener listener;

    @Override
    public void construct(Context context, Listener listener) {

        this.context = context;
        this.listener = listener;
    }

    @Override
    public void logar(Usuario usuario) {
        listener.erro(new Exception("Mock Não logou"));
    }
}
