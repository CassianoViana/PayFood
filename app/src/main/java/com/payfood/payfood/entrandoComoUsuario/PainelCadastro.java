package com.payfood.payfood.entrandoComoUsuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Usuario;

import framework.Painel;
import framework.util.FrameworkUtil;

public class PainelCadastro extends Painel {

    private Listener listener;
    private Button btnEconomizar;
    private TextView txtEmail, txtUsuario, txtSenha;
    PostUsuario post;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        associarComponentes(view);
        configurarEventos();
        PostUsuarioListener listenerPost = new PostUsuarioListener();
        post = new PostUsuario(getActivity(), listenerPost);
        return view;
    }

    private void associarComponentes(View v) {
        btnEconomizar = (Button) v.findViewById(R.id.btn_economizar);
        txtEmail = (TextView) v.findViewById(R.id.txtEmail);
        txtUsuario = (TextView) v.findViewById(R.id.txtUsuario);
        txtSenha = (TextView) v.findViewById(R.id.txtSenha);
    }

    private void configurarEventos() {

        btnEconomizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.nome = txtUsuario.getText().toString();
                usuario.email = txtEmail.getText().toString();
                usuario.senha = txtSenha.getText().toString();
                post.salvarUsuario(usuario);
            }
        });
    }

    public interface Listener {
        void sucesso(Usuario usuario);
    }

    private class PostUsuarioListener implements PostUsuario.Listener {
        @Override
        public void sucesso(Usuario usuario) {
            listener.sucesso(usuario);
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(getActivity(), e);
        }
    }
}
