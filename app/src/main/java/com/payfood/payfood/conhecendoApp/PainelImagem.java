package com.payfood.payfood.conhecendoApp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import framework.Painel;

public class PainelImagem extends Painel {

    private int imagemId;
    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = new LinearLayout(this.getActivity());
        //view.setBackground(getResources().getDrawable(imagemId, null));
        return view;
    }

    public void setImagem(int imagemId){
        this.imagemId = imagemId;
    }

    public static PainelImagem criar(int imagemId) {
        PainelImagem painelImagem = new PainelImagem();
        painelImagem.setImagem(imagemId);
        return painelImagem;
    }
}
