package framework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Painel extends Fragment {

    private ListenerSolicitacaoAbrirOutraTela gerenciadorTelas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return aoCriar(inflater, container);
    }

    protected abstract View aoCriar(LayoutInflater inflater, ViewGroup container);

    public void addListenerSolicitacaoAbrirOutraTela(ListenerSolicitacaoAbrirOutraTela gerenciadorFragments) {
        gerenciadorTelas = gerenciadorFragments;
    }

    public ListenerSolicitacaoAbrirOutraTela getGerenciadorTelas() {
        return gerenciadorTelas;
    }
}