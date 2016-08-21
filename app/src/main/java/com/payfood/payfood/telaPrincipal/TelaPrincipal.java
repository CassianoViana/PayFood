package com.payfood.payfood.telaPrincipal;

import android.os.Bundle;
import android.util.Log;

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
        gerenciadorFragments.mostrar(itemMenu.fragmentName);
        drawerMenu.fechar();
    }
}