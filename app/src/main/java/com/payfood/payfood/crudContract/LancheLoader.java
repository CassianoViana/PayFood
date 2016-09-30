package com.payfood.payfood.crudContract;

import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.entidades.Produto;

public interface LancheLoader {
    void construct(Listener listener);
    void carregar(Produto produto);

    interface Listener extends Carregador.Listener {

    }
}
