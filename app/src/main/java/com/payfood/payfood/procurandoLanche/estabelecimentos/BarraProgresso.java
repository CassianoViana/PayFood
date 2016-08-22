package com.payfood.payfood.procurandoLanche.estabelecimentos;

import android.view.View;
import android.widget.ProgressBar;

import com.payfood.payfood.R;

/**
 * Created by cassiano on 21/08/16.
 */
public class BarraProgresso {
    private final ProgressBar progressBar;

    public BarraProgresso(View view) {
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }

    public void progresso(double done, long total) {
        progressBar.setMax((int) total);
        progressBar.setProgress((int) done);
        if(done == total)
            progressBar.setProgress(0);
    }

    public void zerar() {
        progressBar.setProgress(0);
    }
}
