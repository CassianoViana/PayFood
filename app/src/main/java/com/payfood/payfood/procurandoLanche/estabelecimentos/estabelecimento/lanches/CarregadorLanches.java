package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entidades.Produto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import minhaLang.json.SecureJsonObject;

public class CarregadorLanches extends Carregador<List<Produto>> {

    private List<Produto> lanches;
    private Listener listener;

    public CarregadorLanches(Listener listener, List<Produto> lanches) {
        this.listener = listener;
        this.lanches = lanches;
    }

    public void carregar(Estabelecimento estabelecimento){

        String url = ApiWeb.produto.lista + "/" + estabelecimento.getId();

        RestClient.get(url, null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        SecureJsonObject job = new SecureJsonObject(response.getJSONObject(i));
                        Produto produto = new Produto();
                        produto.id = job.getString("_id");
                        produto.nome = job.getString("name");
                        produto.imgUrl = job.getString("imgUrl");
                        produto.descricao = job.getString("description");
                        produto.preco = job.getBigDecimal("preco");
                        produto.estabelecimentoId = job.getString("estabelecimento_id");
                        lanches.add(0, produto);
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

    public void setLanches(List<Produto> lanches) {
        this.lanches = lanches;
    }
}
