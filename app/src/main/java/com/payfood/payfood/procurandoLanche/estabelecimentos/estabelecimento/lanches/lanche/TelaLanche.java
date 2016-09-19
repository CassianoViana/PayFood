package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.loopj.android.http.RequestParams;
import com.payfood.payfood.R;
import com.payfood.payfood.comunicacaoExterna.Carregador;
import com.payfood.payfood.config.RequestCodes;
import com.payfood.payfood.entidades.Produto;

import framework.Tela;
import framework.userAccountManagement.GerenciadorUsuario;
import framework.userAccountManagement.exceptions.UserAccountException;
import framework.userAccountManagement.exceptions.UsuarioNaoLogadoException;
import framework.userAccountManagement.exceptions.UsuarioNaoRegistradoException;
import framework.util.FrameworkUtil;
import minhaLang.Util;

public class TelaLanche extends Tela {

    private static final String TAG = TelaLanche.class.getSimpleName();
    Produto produto;
    ImageView imagemProduto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lanche);
        imagemProduto = (ImageView) findViewById(R.id.imagem_produto);

        String nome = getIntent().getStringExtra("nomeProduto");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(nome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        carregarLanche();
    }

    private void carregarLanche() {
        produto = new Produto();
        Carregador.Listener listener = new CarregadorListener();
        CarregadorLanche carregadorLanche = new CarregadorLanche(produto, listener);
        RequestParams params = new RequestParams();
        String produtoId = getIntent().getStringExtra("produto_id");
        params.put("produto_id", produtoId);
        carregadorLanche.carregar(params);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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
        Log.d(TAG, "Pedir");
    }

    private void resolverProblemaContaAoPedir(UserAccountException e) {
        GerenciadorUsuario.instance(this).registrar(RequestCodes.REQUEST_CODE_LOGAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        pedir(produto);
    }
}
