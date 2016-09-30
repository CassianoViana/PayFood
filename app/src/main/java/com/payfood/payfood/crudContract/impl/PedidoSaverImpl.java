package com.payfood.payfood.crudContract.impl;

import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.crudContract.PedidoSaver;
import com.payfood.payfood.entidades.Pedido;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class PedidoSaverImpl implements PedidoSaver {

    private static final int MAX_TENTATIVAS = 2;
    Context context;
    Listener listener;

    @Override
    public void construct(Context context, Listener listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void save(final Pedido pedido) {
        try {

            JSONObject pedidoJson = new JSONObject(), clienteJson = new JSONObject(), produtoJson = new JSONObject();
            clienteJson.put("id", pedido.getUsuario().getId());
            clienteJson.put("name", pedido.getUsuario().getNome());
            pedidoJson.put("cliente", clienteJson);
            produtoJson.put("id", pedido.getProduto().getId());
            produtoJson.put("nome", pedido.getProduto().getNome());
            produtoJson.put("preco", pedido.getProduto().getPreco());
            pedidoJson.put("produto", produtoJson);
            pedidoJson.put("estabelecimento_id", pedido.getEstabelecimento().getId());

            StringEntity pedidoEntity = new StringEntity(pedidoJson.toString());

            String url = ApiWeb.pedido.post;
            RestClient.postJson(context, url, pedidoEntity, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    listener.sucesso(pedido);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    listener.erro(throwable);
                }

                @Override
                public void onRetry(int retryNo) {
                    if (retryNo == MAX_TENTATIVAS) {
                        listener.erro(new Exception("Não foi possível completar o pedido"));
                        super.sendCancelMessage();
                    }

                }
            });
        } catch (Exception e) {
            listener.erro(e);
            e.printStackTrace();
        }
    }
}
