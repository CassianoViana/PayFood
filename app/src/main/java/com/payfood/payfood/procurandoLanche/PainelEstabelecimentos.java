package com.payfood.payfood.procurandoLanche;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Lanchonete;

import framework.Painel;
import minhaLang.CarregadorDados;

public class PainelEstabelecimentos extends Painel {

    public PainelEstabelecimentos() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estabelecimentos, container, false);
        return view;
    }
}
