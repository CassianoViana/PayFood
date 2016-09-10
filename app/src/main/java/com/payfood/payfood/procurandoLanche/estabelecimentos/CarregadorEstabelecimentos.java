package com.payfood.payfood.procurandoLanche.estabelecimentos;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Estabelecimento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CarregadorEstabelecimentos {

    private Listener listener;

    public CarregadorEstabelecimentos(Listener listener){
        this.listener = listener;
    }

    public void carregar(final List<Estabelecimento> estabelecimentos) {

        RestClient.get(ApiWeb.estabelecimento.lista, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject job = response.getJSONObject(i);
                        Estabelecimento estabelecimento = new Estabelecimento();
                        estabelecimento.id = job.getString("_id");
                        estabelecimento.nome = job.getString("name");
                        estabelecimento.endereco = job.getString("address");
                        estabelecimento.imgUrl = job.getString("imgUrl");
                        estabelecimento.descricao = job.getString("descricao");
                        estabelecimento.setAvaliacao(job.getDouble("stars"));
                        estabelecimentos.add(0, estabelecimento);
                        listener.carregadorTerminou();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.carregadorFalhou(1, e);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                listener.carregadorFalhou(statusCode, throwable);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject jsonObject) {
                super.onFailure(statusCode, headers, throwable, jsonObject);
                listener.carregadorFalhou(statusCode, throwable);
            }

            @Override
            public void onProgress(long bytesWritten, long totalSize) {
                super.onProgress(bytesWritten, totalSize);
                listener.carregadorProgrediu(bytesWritten, totalSize);
            }
        });
    }

    public interface Listener{
        void carregadorTerminou();
        void carregadorFalhou(int statusCode, Throwable error);
        void carregadorProgrediu(double done, long total);
    }
}