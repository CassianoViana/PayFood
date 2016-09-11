package com.payfood.payfood.comunicacaoExterna;

public class Carregador<T> {

    public interface Listener {
        void carregadorTerminou();
        void carregadorFalhou(int statusCode, Throwable error);
        void carregadorProgrediu(double done, long total);
    }
}
