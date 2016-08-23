package com.payfood.payfood.telaPrincipal;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

import com.payfood.payfood.R;

import framework.GerenciadorFragments;
import framework.Tela;

public class TelaPrincipal extends Tela implements MenuLateral.ListenerItemClick{

    private DrawerMenu drawerMenu;
    private MenuLateral menuLateral;
    private BarraTopo barraTopo;
    private GerenciadorFragments gerenciadorFragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        menuLateral = new MenuLateral(this);
        barraTopo = new BarraTopo(this);
        drawerMenu = new DrawerMenu(this, barraTopo.getToolbar());
        gerenciadorFragments = new GerenciadorFragments(this);
    }

    @Override
    public void clicou(MenuLateral.Item itemMenu) {
        barraTopo.setTitulo(itemMenu.nome);
        gerenciadorFragments.mostrar(itemMenu.fragmentName);
        drawerMenu.fechar();
        supportInvalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tela_validacao, menu);
        return super.onCreateOptionsMenu(menu);
    }
}