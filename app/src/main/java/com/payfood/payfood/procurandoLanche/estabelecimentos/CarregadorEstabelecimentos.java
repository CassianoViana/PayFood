package com.payfood.payfood.procurandoLanche.estabelecimentos;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entidades.Localizacao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import cz.msebera.android.httpclient.Header;
import minhaLang.json.SecureJsonObject;

public class CarregadorEstabelecimentos extends Carregador<Estabelecimento>{

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
                        SecureJsonObject job = new SecureJsonObject(response.getJSONObject(i));
                        Estabelecimento estabelecimento = new Estabelecimento(job.getString("_id"));
                        estabelecimento.setNome(job.getString("name"));
                        estabelecimento.setEndereco(job.getString("address"));
                        SecureJsonObject locJob = job.getJob("location");
                        estabelecimento.setLocation(new Localizacao(locJob.getDouble("x"), locJob.getDouble("y")));
                        estabelecimento.setImgUrl(job.getString("imgUrl"));
                        estabelecimento.setDescricao(job.getString("descricao"));
                        estabelecimento.setAvaliacaoDouble(job.getDouble("stars"));
                        estabelecimentos.add(0, estabelecimento);
                    }
                    listener.carregadorTerminou();
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
}