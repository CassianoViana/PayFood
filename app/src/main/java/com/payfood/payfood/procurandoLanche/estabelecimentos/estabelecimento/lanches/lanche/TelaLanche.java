package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.payfood.payfood.R;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.appconstants.RequestCode;
import com.payfood.payfood.appconstants.ResultCode;
import com.payfood.payfood.entidades.Estabelecimento;
import com.payfood.payfood.entidades.Pedido;
import com.payfood.payfood.entidades.Produto;
import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.userAccountManagement.exceptions.UserAccountException;
import framework.util.FrameworkUtil;
import minhaLang.Util;

public class TelaLanche extends Tela {

    private static final String TAG = TelaLanche.class.getSimpleName();
    Produto produto;
    ImageView imagemProduto;
    PostPedido postPedido;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lanche);
        imagemProduto = (ImageView) findViewById(R.id.imagem_produto);

        produto = (Produto) getIntent().getSerializableExtra("produto");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(produto.getNome());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        postPedido = new PostPedido(this, new PostPedidoListener());

        carregarLanche();
    }

    private void carregarLanche() {
        Carregador.Listener listener = new CarregadorListener();
        CarregadorLanche carregadorLanche = new CarregadorLanche(listener);
        carregadorLanche.carregar(produto);
    }

    private class CarregadorListener implements Carregador.Listener {
        @Override
        public void carregadorTerminou() {
            Util.glidImage(imagemProduto, produto.imgUrl, TelaLanche.this, R.drawable.ic_local_pizza_black_24dp);
        }

        @Override
        public void carregadorFalhou(int statusCode, Throwable error) {
            FrameworkUtil.instance().manipularErro(TelaLanche.this, error);
        }

        @Override
        public void carregadorProgrediu(double done, long total) {

        }
    }

    public void onClickPedir(View view) {
        try {
            if (GerenciadorUsuario.instance(this).verify())
                pedir(produto);
        } catch (UserAccountException problema) {
            resolverProblemaContaAoPedir(problema);
        }
    }

    private void pedir(Produto produto) {
        Pedido pedido = new Pedido();

        Usuario usuario = GerenciadorUsuario.instance(this).getUsuario();
        Estabelecimento estabelecimento = new Estabelecimento();

        pedido.setProduto(produto);
        pedido.setUsuario(usuario);
        pedido.setEstabelecimento(estabelecimento);
        postPedido.enviarPedido(pedido);

        Log.d(TAG, "Pedir");
    }

    private void resolverProblemaContaAoPedir(UserAccountException e) {
        GerenciadorUsuario.instance(this).registrar(RequestCode.LOGAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == ResultCode.LOGOU)
            pedir(produto);
    }


    private class PostPedidoListener implements PostPedido.Listener {
        @Override
        public void sucesso(Pedido usuario) {
            new AlertDialog.Builder(TelaLanche.this).setMessage("Pedido enviado!").show();
        }

        @Override
        public void erro(Throwable e) {
            new AlertDialog.Builder(TelaLanche.this).setMessage("Falha ao enviar pedido!").show();
        }
    }
}
