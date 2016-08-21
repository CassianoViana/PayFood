package com.payfood.payfood.telaPrincipal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.payfood.payfood.R;

import framework.Painel;

public class DashBoard extends Painel {

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return view;
    }
}
