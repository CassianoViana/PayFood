package com.payfood.payfood.procurandoLanche;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.payfood.payfood.R;

import framework.Tela;

public class TelaPrincipal extends Tela {

    private static final String TAG = TelaPrincipal.class.getSimpleName();
    private NavigationView navegador;
    private DrawerLayout drawerLayout;
    private Toolbar barraFerramentas;

    @Override
    protected void aoCriar() {
        setContentView(R.layout.tela_principal);
        obterComponentesDoLayout();
        configurarToolbar();
        configurarNavegador();
    }

    private void obterComponentesDoLayout() {
        navegador = (NavigationView) findViewById(R.id.navegador);
        barraFerramentas = (Toolbar) findViewById(R.id.barra_topo);

    }

    private void configurarToolbar() {
        setSupportActionBar(barraFerramentas);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }
    }

    private void configurarNavegador() {
        navegador.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                return false;
            }
        });
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggleNavegador = new ActionBarDrawerToggle(this, drawerLayout, R.string.abrindo_navegador, R.string.fechando_navegador);
        drawerLayout.addDrawerListener(toggleNavegador);
        toggleNavegador.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == android.R.id.home)
            toggleNavegador();
        Log.d(TAG, "TESTE");
        return true;
    }

    private void toggleNavegador() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.openDrawer(GravityCompat.START);
        else
            drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.barra_topo, menu);
        return true;
    }
}