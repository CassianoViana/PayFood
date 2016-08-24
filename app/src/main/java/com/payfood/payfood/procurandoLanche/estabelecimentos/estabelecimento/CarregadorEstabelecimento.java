package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Estabelecimento;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by cassiano on 8/23/16.
 */
public class CarregadorEstabelecimento {

    Listener listener;
    public CarregadorEstabelecimento(Listener listener) {
        this.listener = listener;
    }

    public void carregar(final Estabelecimento estabelecimento) {
        RequestParams params = new RequestParams();
        params.put("id", estabelecimento.id);
        RestClient.get("/estabelecimento", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    estabelecimento.imgUrl = response.getString("img");
                    listener.carregouEstabelecimento(estabelecimento);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface Listener {
        void carregouEstabelecimento(Estabelecimento estabelecimento);
    }
}
