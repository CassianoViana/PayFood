package com.payfood.payfood.crudContract.mock.failMock;

import com.payfood.payfood.crudContract.LancheLoader;
import com.payfood.payfood.entidades.Produto;

/**
 * Created by cassiano on 30/09/16.
 */

public class LancheLoaderImplFail implements LancheLoader {
    private Listener listener;

    @Override
    public void construct(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void carregar(Produto produto) {
        listener.carregadorFalhou(200, new Exception("Falha"));
    }
}
