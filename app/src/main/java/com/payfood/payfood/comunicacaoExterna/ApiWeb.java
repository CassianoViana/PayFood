package com.payfood.payfood.comunicacaoExterna;

public class ApiWeb {

    static final String BASE_URL = "https://payfood-api-dev-cesarviana.c9users.io";

    public static class estabelecimento {
        public static String lista = "/estabelecimento";
    }

    public static class usuario {
        public static String post = "/usuario";
    }

    public static class produto {
        public static String lista = "/produtos/estabelecimento";
        public static String get = "/produto";
    }

    public static class pedido {
        public static String post = "/pedido";
    }
}
