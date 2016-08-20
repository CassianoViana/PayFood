package framework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Painel extends Fragment {

    private GerenciadorTelas gerenciadorTelas;

    protected abstract View aoCriar(LayoutInflater inflater, ViewGroup container);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return aoCriar(inflater, container);
    }

    public void chamar(Class painel) {
        gerenciadorTelas.chamar(painel);
    }

    public Painel sairDaPilha(){
        gerenciadorTelas.retirarDaPilha(this.getClass());
        return this;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void setGerenciadorTelas(GerenciadorTelas gerenciadorTelas) {
        this.gerenciadorTelas = gerenciadorTelas;
    }
}