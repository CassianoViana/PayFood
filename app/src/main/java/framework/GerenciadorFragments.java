package framework;


import android.support.v4.app.FragmentManager;

import com.payfood.payfood.R;

public class GerenciadorFragments {

    private final Tela context;

    public GerenciadorFragments(Tela context) {
        this.context = context;
    }

    public void mostrar(String fragmentName) {
        Painel painel = null;
        try {
            painel = (Painel) Class.forName(fragmentName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = context.getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.conteudo_centro_drawer, painel).commit();
    }
}
