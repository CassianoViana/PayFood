package framework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Painel extends Fragment {

    protected View aoCriar(LayoutInflater inflater, ViewGroup container){return null;};

    public Painel(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return aoCriar(inflater, container);
    }

}