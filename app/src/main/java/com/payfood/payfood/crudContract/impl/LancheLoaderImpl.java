package com.payfood.payfood.crudContract.impl;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.crudContract.LancheLoader;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entidades.Produto;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import minhaLang.json.SecureJsonObject;

public class LancheLoaderImpl implements LancheLoader {

    private Listener listener;

    public void construct(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void carregar(final Produto produto) {
        String url = ApiWeb.produto.get + "/" + produto.getId();
        RestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                SecureJsonObject job = new SecureJsonObject(response);
                produto.setId(job.getString("_id"));
                produto.setNome(job.getString("name"));
                produto.setImgUrl(job.getString("imgUrl"));
                produto.setDescricao(job.getString("description"));
                produto.setPreco(job.getBigDecimal("preco"));
                produto.setEstabelecimento(new Estabelecimento(job.getString("estabelecimento_id")));
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
