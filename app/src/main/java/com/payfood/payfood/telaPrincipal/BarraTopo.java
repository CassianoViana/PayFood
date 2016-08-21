package com.payfood.payfood.telaPrincipal;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import com.payfood.payfood.R;

import framework.Tela;

/**
 * Created by cassiano on 20/08/16.
 */
public class BarraTopo {

    private Toolbar toolbar;

    public BarraTopo(Tela context) {
        toolbar = (Toolbar) context.findViewById(R.id.toolbar);
        toolbar.setTitle("Teste");

        context.setSupportActionBar(toolbar);
        context.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }
}
