package com.payfood.payfood.crudContract.impl;


import android.content.Context;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.payfood.payfood.comunicacaoExterna.ApiWeb;
import com.payfood.payfood.comunicacaoExterna.RestClient;
import com.payfood.payfood.crudContract.LoginPost;
import com.payfood.payfood.entidades.Usuario;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;
import minhaLang.json.SecureJsonObject;

public class LoginPostImpl implements LoginPost {
    private Context context;
    private Listener listener;

    @Override
    public void construct(Context context, Listener listener) {

        this.context = context;
        this.listener = listener;
    }

    @Override
    public void logar(final Usuario usuario) {
        try {

            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("email", usuario.getEmail());
            usuarioJson.put("password", usuario.getSenha());

            StringEntity usuarioEntity = new StringEntity(usuarioJson.toString());

            String url = ApiWeb.usuario.login;
            RestClient.postJson(context, url, usuarioEntity, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    SecureJsonObject job = new SecureJsonObject(response);
                    Usuario usuario = new Usuario();
                    usuario.setId(job.getString("_id"));
                    usuario.setNome(job.getString("name"));
                    usuario.setEmail(job.getString("email"));
                    listener.sucesso(usuario);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    listener.erro(throwable);
                }

                @Override
                public void onRetry(int retryNo) {
                    if (retryNo == ApiWeb.MAX_TENTATIVAS) {
                        listener.erro(new Exception("Não foi possível logar"));
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
