package com.payfood.payfood.crudContract.mock.successMock;

import android.content.Context;

import com.payfood.payfood.crudContract.PedidoSaver;
import com.payfood.payfood.entidades.Pedido;

public class PedidoSaverImplSuccess implements PedidoSaver {
    private Listener listener;

    @Override
    public void save(Pedido Pedido) {
        listener.sucesso(Pedido);
    }

    @Override
    public void construct(Context context, Listener listener) {
        this.listener = listener;
    }
}
