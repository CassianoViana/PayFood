package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Produto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import minhaLang.json.SecureJsonObject;

public class CarregadorLanche extends Carregador<Produto> {

    private Produto produto;
    private Listener listener;

    public CarregadorLanche(Produto produto, Listener listener) {
        this.produto = produto;
        this.listener = listener;
    }

    public void carregar(RequestParams params) {
        RestClient.get(ApiWeb.produto.get, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                SecureJsonObject job = new SecureJsonObject(response);
                produto.id = job.getString("_id");
                produto.nome = job.getString("name");
                produto.imgUrl = job.getString("imgUrl");
                produto.descricao = job.getString("descricao");
                produto.preco = job.getBigDecimal("preco");
                listener.carregadorTerminou();
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
