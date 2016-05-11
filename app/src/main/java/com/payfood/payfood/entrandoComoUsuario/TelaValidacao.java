package com.payfood.payfood.entrandoComoUsuario;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.payfood.payfood.R;
import com.payfood.payfood.telaPrincipal.TelaPrincipal;

import framework.Tela;

public class TelaValidacao extends Tela {

    private Button btnEntrar;

    @Override
    protected void aoCriar() {
        associarComponentes();
        configurarEventos();
    }

    private void associarComponentes() {
        setContentView(R.layout.activity_tela_validacao);
        btnEntrar = (Button) findViewById(R.id.btn_entrar);
    }

    private void configurarEventos() {
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaPrincipal = new Intent(TelaValidacao.this, TelaPrincipal.class);
                startActivity(telaPrincipal);
            }
        });
    }
}
