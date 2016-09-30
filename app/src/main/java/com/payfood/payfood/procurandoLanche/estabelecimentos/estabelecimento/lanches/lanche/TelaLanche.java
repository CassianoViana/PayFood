package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.appconstants.RequestCode;
import com.payfood.payfood.appconstants.ResultCode;
import com.payfood.payfood.crudContract.LancheLoader;
import com.payfood.payfood.crudContract.PedidoSaver;
import com.payfood.payfood.crudContract.impl.LancheLoaderImpl;
import com.payfood.payfood.crudContract.impl.PedidoSaverImpl;
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
    TextView precoProduto, descricaoProduto;
    PedidoSaver saverPedido;
    LancheLoader loaderLanche;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lanche);
        imagemProduto = (ImageView) findViewById(R.id.imagem_produto);
        precoProduto = (TextView) findViewById(R.id.preco_produto);
        descricaoProduto = (TextView) findViewById(R.id.descricao_produto);

        produto = (Produto) getIntent().getSerializableExtra("produto");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(produto.getNome());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        saverPedido = new PedidoSaverImpl();
        saverPedido.construct(this, new PostPedidoListener());

        loaderLanche = new LancheLoaderImpl();
        loaderLanche.construct(new CarregadorListener());
        loaderLanche.carregar(produto);
    }

    private class CarregadorListener implements LancheLoader.Listener {
        @Override
        public void carregadorTerminou() {
            Util.glidImage(imagemProduto, produto.getImgUrl(), TelaLanche.this, R.drawable.ic_local_pizza_black_24dp);
            precoProduto.setText(produto.getPrecoFormatado());
            descricaoProduto.setText(produto.getDescricao());
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
        pedido.setProduto(produto);
        pedido.setUsuario(usuario);
        pedido.setEstabelecimento(produto.getEstabelecimento());
        saverPedido.save(pedido);
    }

    private void resolverProblemaContaAoPedir(UserAccountException e) {
        GerenciadorUsuario.instance(this).registrar(RequestCode.LOGAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == ResultCode.LOGOU)
            pedir(produto);
    }

    private class PostPedidoListener implements PedidoSaver.Listener {
        @Override
        public void sucesso(Pedido usuario) {
            FrameworkUtil.instance().showMessage(TelaLanche.this, R.string.pedido_confirmado, R.string.mensagem_confirmacao_pedido_lanche);
        }

        @Override
        public void erro(Throwable e) {
            FrameworkUtil.instance().manipularErro(TelaLanche.this, e);
        }
    }
}
