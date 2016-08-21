package com.payfood.payfood.procurandoLanche;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.payfood.payfood.R;
import com.payfood.payfood.entrandoComoUsuario.PainelCadastro;

import framework.Painel;

public class PainelPedirLanche extends Painel {

    private Button btnPedir;
    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_pedir_lanche, container, false);
        associarComponentes(view);
        configurarEventos();
        return view;
    }

    private void associarComponentes(View view) {
        btnPedir = (Button) view.findViewById(R.id.btnPedir);
    }

    private void configurarEventos() {
        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(PainelPedirLanche.class.getSimpleName(), "Pedir");            }
        });
    }
}
