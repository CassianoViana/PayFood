package com.payfood.payfood.entrandoComoUsuario;

import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.entidades.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class PostUsuario {

    private static final int MAX_TENTATIVAS = 2;
    Context context;
    Listener listener;

    public PostUsuario(Context context, Listener listener) {
        this.listener = listener;
        this.context = context;
    }

    public void salvarUsuario(final Usuario usuario) {
        try {

            JSONObject jsonParams = new JSONObject();
            jsonParams.put("name", usuario.nome);
            jsonParams.put("email", usuario.email);
            jsonParams.put("password", usuario.senha);

            StringEntity entity = new StringEntity(jsonParams.toString());
            RestClient.postJson(context, ApiWeb.usuario.post, entity, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    listener.sucesso(usuario);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    listener.erro(throwable);
                }

                @Override
                public void onRetry(int retryNo) {
                    if (retryNo == MAX_TENTATIVAS) {
                        listener.erro(new Exception("Tentou logar muitas vezes"));
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
        void sucesso(Usuario usuario);
        void erro(Throwable e);
    }
}
