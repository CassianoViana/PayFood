package com.payfood.payfood.crudContract.impl;

import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.crudContract.UsuarioSaver;
import com.payfood.payfood.entidades.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import minhaLang.json.SecureJsonObject;

public class UsuarioSaverImpl implements UsuarioSaver {
    private Context context;
    private Listener listener;

    @Override
    public void save(final Usuario usuario) {
        try {

            JSONObject jsonUsuario = new JSONObject();
            jsonUsuario.put("_id", usuario.getId());
            jsonUsuario.put("name", usuario.getNome());
            jsonUsuario.put("email", usuario.getEmail());
            jsonUsuario.put("password", usuario.getSenha());

            StringEntity usuarioEntity = new StringEntity(jsonUsuario.toString());

            String url = ApiWeb.usuario.post;
            JsonHttpResponseHandler responseHandler = new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    SecureJsonObject job = new SecureJsonObject(response);
                    usuario.setId(job.getString("_id"));
                    usuario.setEmail(job.getString("email"));
                    usuario.setNome(job.getString("name"));
                    listener.sucesso(usuario);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    listener.erro(throwable);
                }

                @Override
                public void onRetry(int retryNo) {
                    if (retryNo == ApiWeb.MAX_TENTATIVAS) {
                        listener.erro(new Exception("Não foi possível cadastrar o usuario"));
                        super.sendCancelMessage();
                    }

                }
            };
            boolean novo = "".equals(usuario.getId()) || usuario.getId() == null;
            if (novo)
                RestClient.postJson(context, url, usuarioEntity, responseHandler);

            boolean edid = usuario.getId() != null;
            if (edid)
                RestClient.putJson(context, url, usuarioEntity, responseHandler);

        } catch (JSONException | UnsupportedEncodingException e) {
            listener.erro(e);
            e.printStackTrace();
        }
    }

    @Override
    public void construct(Context context, Listener listener) {
        this.context = context;
        this.listener = listener;
    }
}