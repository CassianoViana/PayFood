package com.payfood.payfood.entrandoComoUsuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.payfood.payfood.R;
import com.payfood.payfood.telaPrincipal.TelaPrincipal;

import framework.Painel;

public class PainelValidacaoEmail extends Painel {

    private Button btnEntrar;

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_tela_validacao, container, false);
        associarComponentes(view);
        configurarEventos();
        return view;
    }

    private void associarComponentes(View view) {
        btnEntrar = (Button) view.findViewById(R.id.btn_entrar);
    }

    private void configurarEventos() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamar(TelaPrincipal.class);
            }
        });
    }

}
