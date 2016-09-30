package com.payfood.payfood.crudContract;

import android.content.Context;

import com.payfood.payfood.entidades.Pedido;

public interface PedidoSaver {

    void construct(Context context, Listener listener);
    void save(Pedido pedido);

    interface Listener {
        void sucesso(Pedido pedido);
        void erro(Throwable e);
    }
}
