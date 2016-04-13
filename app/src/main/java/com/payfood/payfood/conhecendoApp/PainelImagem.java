package com.payfood.payfood.conhecendoApp;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Random;

import framework.Painel;

public class PainelImagem extends Painel {

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = new LinearLayout(this.getActivity());
        Random rnd = new Random();
        view.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
        return view;
    }
}
