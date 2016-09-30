package com.payfood.payfood.telaPrincipal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;

/**
 * Created by cassiano on 30/09/16.
 */

public class RegiaoMenuLayoutLogout {
    private ListenerLogoutClick listenerClickSair;

    private ImageButton btnSair;
    private TextView txtNomeLogado;
    private ViewGroup layoutSair;

    public RegiaoMenuLayoutLogout(Tela context) {
        this.listenerClickSair = (ListenerLogoutClick) context;

        layoutSair = (ViewGroup) context.findViewById(R.id.layout_sair);
        txtNomeLogado = (TextView) context.findViewById(R.id.txt_nome_logado);

        btnSair = (ImageButton) context.findViewById(R.id.btn_sair);
        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listenerClickSair.clicouParaSair();
            }
        });

        atualizarContent(context);
    }

    public void atualizarContent(Tela context) {
        Usuario usuario = GerenciadorUsuario.instance(context).getUsuario();
        int layoutSairVisivel = usuario != Usuario.NULL ? View.VISIBLE : View.GONE;
        layoutSair.setVisibility(layoutSairVisivel);
        txtNomeLogado.setText(usuario.getNome());
    }

    public interface ListenerLogoutClick {
        void clicouParaSair();
    }
}
