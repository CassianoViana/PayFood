package framework;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.payfood.payfood.R;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorTelas {

    private FragmentManager fragmentManager;
    private Map<String, Painel> mapa;

    public GerenciadorTelas(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
        this.mapa = new HashMap<>();
    }

    public void chamar(Class nomeClassePainel) {
        String nome = nomeClassePainel.getName();
        Painel painel = getPainelPor(nome);
        abrirPainel(nome, painel);
    }

    private void abrirPainel(String nome, Painel painel) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.conteudo, painel);
        fragmentTransaction.addToBackStack(nome);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private Painel getPainelPor(String nome) {
        boolean jaAdicionado = mapa.containsKey(nome);
        Painel painel;
        if (jaAdicionado) {
            painel = mapa.get(nome);
        } else {
            painel = instanciarNovoPainelAPartirDo(nome);
            painel.setGerenciadorTelas(this);
            mapa.put(nome, painel);
        }
        return painel;
    }

    private Painel instanciarNovoPainelAPartirDo(String nome) {
        try {
            return (Painel) Class.forName(nome).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return new PainelNull();
        }
    }

    public void retirarDaPilha(Class nome) {
        String painelNome = nome.getName();
        Painel painel = mapa.get(painelNome);
        FragmentTransaction trans = fragmentManager.beginTransaction();
        trans.remove(painel);
        trans.commit();
        fragmentManager.popBackStack();
        mapa.remove(painelNome);
    }
}
