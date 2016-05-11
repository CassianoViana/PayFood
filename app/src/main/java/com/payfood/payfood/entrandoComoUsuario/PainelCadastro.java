package com.payfood.payfood.entrandoComoUsuario;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.payfood.payfood.R;
import com.payfood.payfood.comunicacaoExterna.PayFoodRestClient;
import com.payfood.payfood.procurandoLanche.PainelLanches;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;

import cz.msebera.android.httpclient.Header;
import framework.Painel;

public class PainelCadastro extends Painel {

    private Button btnEconomizar;
    private TextView txtEmail, txtUsuario, txtSenha;

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        associarComponentes(view);
        configurarEventos();
        return view;
    }

    private void associarComponentes(View v) {
        btnEconomizar = (Button) v.findViewById(R.id.btn_economizar);
        txtEmail = (TextView) v.findViewById(R.id.txtEmail);
        txtUsuario = (TextView) v.findViewById(R.id.txtUsuario);
        txtSenha = (TextView) v.findViewById(R.id.txtSenha);
    }

    private void configurarEventos() {
        btnEconomizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (validarFormulario()) {
                    cadastrar();
                //}
            }
        });
    }

    private boolean validarFormulario() {
        boolean formularioValido = formularioValido();
        if (!formularioValido)
            new AlertDialog.Builder(getActivity())
                    .setTitle("Dados inválidos")
                    .setMessage("Verifique se você informou todos os dados corretamente!")
                    .show();
        return formularioValido;
    }

    private void cadastrar() {
        RequestParams params = new RequestParams();
        params.put("email", txtEmail.getText().toString());
        params.put("usuario", txtUsuario.getText().toString());
        params.put("senha", txtSenha.getText().toString());
        PayFoodRestClient.post("usr", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                mostrarMensagemSucessoCadastro();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                mostrarMensagemFalhaCadastro();
            }
        });
    }

    private boolean formularioValido() {
        return !txtEmail.getText().toString().isEmpty()
                && !txtUsuario.getText().toString().isEmpty()
                && !txtSenha.getText().toString().isEmpty();
    }


    private void mostrarMensagemSucessoCadastro() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Cadastro realizado")
                .setMessage("Parabens! Cadastro realizado com sucesso!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getGerenciadorTelas().mostrar(new PainelLanches());
                    }
                })
                .create().show();
    }


    private void mostrarMensagemFalhaCadastro() {
        new AlertDialog.Builder(getActivity())
                .setTitle("Falha")
                .setMessage("Ocorreu uma falha ao cadastrar o usuário..")
                .setPositiveButton("OK", null)
                .create().show();
    }



}
