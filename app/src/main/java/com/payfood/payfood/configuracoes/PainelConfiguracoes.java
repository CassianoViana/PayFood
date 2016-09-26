package com.payfood.payfood.configuracoes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.payfood.payfood.R;
import com.payfood.payfood.configuracoes.usuario.perfil.TelaPerfil;

import framework.Painel;

public class PainelConfiguracoes extends Painel {

    Button btnConfigurarPerfil;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_configuracoes, container, false);
        btnConfigurarPerfil = (Button) view.findViewById(R.id.btn_configurar_perfil);
        btnConfigurarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(), TelaPerfil.class));
            }
        });
        return view;
    }
}
