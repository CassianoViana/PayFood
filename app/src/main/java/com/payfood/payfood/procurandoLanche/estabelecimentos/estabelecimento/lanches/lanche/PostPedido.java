package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche;

import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Pedido;
import com.payfood.payfood.entidades.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class PostPedido {

    private static final int MAX_TENTATIVAS = 2;
    Context context;
    Listener listener;

    public PostPedido(Context context, Listener listener) {
        this.listener = listener;
        this.context = context;
    }

    public void enviarPedido(final Pedido pedido) {
        try {

            JSONObject jsonPedido = new JSONObject();
            jsonPedido.put("produto_id", pedido.getProduto().getId());
            jsonPedido.put("estabelecimento_id", pedido.getEstabelecimento().getId());
            jsonPedido.put("usuario_id", pedido.getUsuario().getId());
            jsonPedido.put("cliente", pedido.getUsuario().getNome());
            jsonPedido.put("pedido", pedido.getProduto().getNome());

            StringEntity pedidoEntity = new StringEntity(jsonPedido.toString());

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
        } catch (JSONException | UnsupportedEncodingException e) {
            listener.erro(e);
            e.printStackTrace();
        }
    }

    public interface Listener {
        void sucesso(Pedido usuario);

        void erro(Throwable e);
    }
}
