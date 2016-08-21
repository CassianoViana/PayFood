package com.payfood.payfood.telaPrincipal;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.payfood.payfood.R;

import framework.Tela;

public class DrawerMenu {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    public DrawerMenu(final Tela context, Toolbar toolbar) {
        mDrawerLayout = (DrawerLayout) context.findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(context,mDrawerLayout, toolbar, R.string.drawer_open,R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                context.invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                context.invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    public void fechar() {
        mDrawerLayout.closeDrawers();
    }
}
