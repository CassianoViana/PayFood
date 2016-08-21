package framework;

import com.payfood.payfood.telaPrincipal.DashBoard;

import java.util.LinkedList;

public class GeneratorFragments {

    private static GeneratorFragments instance;

    private GeneratorFragments(){

    }

    public static GeneratorFragments getInstance(){
        if(instance == null){
            instance = new GeneratorFragments();
        }
        return instance;
    }

    public Painel getFragment(int posicao) {
        //LinkedList<Painel> fragments = new LinkedList();
        //return fragments.get(posicao);

        Painel painel = new DashBoard();
        return painel;
    }
}
