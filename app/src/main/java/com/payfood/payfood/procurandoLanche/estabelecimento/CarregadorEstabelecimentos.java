package com.payfood.payfood.procurandoLanche.estabelecimento;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Estabelecimento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import minhaLang.CarregadorDados;

public class CarregadorEstabelecimentos {

    private Listener listener;

    public CarregadorEstabelecimentos(Listener listener){
        this.listener = listener;
    }

    public void carregar(final List<Estabelecimento> estabelecimentos) {

        RestClient.get("/estabelecimentos", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject job = response.getJSONObject(i);
                        Estabelecimento estabelecimento = new Estabelecimento();
                        estabelecimento.id = job.getInt("id");
                        estabelecimento.nome = job.getString("name");
                        estabelecimento.endereco = job.getString("address");
                        estabelecimentos.add(estabelecimento);
                        listener.carregou();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                listener.falhou(statusCode, errorResponse);
            }
        });
    }

    public interface Listener{
        void carregou();
        void falhou(int statusCode, JSONObject errorResponse);
    }
}
