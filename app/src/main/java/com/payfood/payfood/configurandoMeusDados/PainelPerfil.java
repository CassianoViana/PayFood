package com.payfood.payfood.configurandoMeusDados;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.payfood.payfood.R;

import framework.Painel;

public class PainelPerfil extends Painel {

    private Button btnEditarDadosUsuario;

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        associarComponentes(view);
        configurarAcoes();
        return view;
    }

    private void associarComponentes(View view) {
        btnEditarDadosUsuario = (Button) view.findViewById(R.id.btn_editar_perfil);
    }

    private void configurarAcoes() {
        btnEditarDadosUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(PainelPerfil.class.getSimpleName(), "Editar dados do usuário");
            }
        });
    }


}
