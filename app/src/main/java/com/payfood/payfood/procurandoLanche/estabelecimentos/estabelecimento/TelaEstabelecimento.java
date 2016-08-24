package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;

import framework.Tela;

public class TelaEstabelecimento extends Tela implements CarregadorEstabelecimento.Listener {

    ImageView bannerEstabelecimento;
    ListView listaProdutos;
    Estabelecimento estabelecimento;
    CarregadorEstabelecimento carregadorEstabelecimento;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_estabelecimento);
        bannerEstabelecimento = (ImageView) findViewById(R.id.banner_estabelecimento);
        listaProdutos = (ListView) findViewById(R.id.lista_produtos);

        String nome = getIntent().getStringExtra("nome");
        int id = getIntent().getIntExtra("id", 0);

        estabelecimento = new Estabelecimento();
        estabelecimento.id = id;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(nome);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        carregadorEstabelecimento = new CarregadorEstabelecimento(this);
        carregadorEstabelecimento.carregar(estabelecimento);
        carregarProdutos();
    }

    private void carregarProdutos() {
        String[] itens = {"TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE", "TESTE"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
        listaProdutos.setAdapter(adapter);
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

    @Override
    public void carregouEstabelecimento(Estabelecimento estabelecimento) {
        Log.d("TESTE", estabelecimento.getImgUrl());
    }
}
