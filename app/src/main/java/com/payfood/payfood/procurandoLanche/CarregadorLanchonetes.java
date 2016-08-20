package com.payfood.payfood.procurandoLanche;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.PayFoodRestClient;
import com.payfood.payfood.entidades.Lanchonete;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import cz.msebera.android.httpclient.Header;
import minhaLang.CarregadorDados;

public class CarregadorLanchonetes implements CarregadorDados<Lanchonete> {
    @Override
    public Collection<Lanchonete> getDados() {
        PayFoodRestClient.get("/estabelecimentos", null, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println(statusCode);
                System.out.println(headers);
                System.out.println(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println(statusCode);
                System.out.println(headers);
                System.out.println(responseBody);
            }
        });
        ArrayList<Lanchonete> arrayList = new ArrayList<>();
        return arrayList;
    }
}
