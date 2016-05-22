package com.payfood.payfood.procurandoLanche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Produto;

import framework.Painel;
import minhaLang.CarregadorDados;

public class PainelLanches extends Painel {
    private CarregadorDados<Produto> carregadorDados;

    public PainelLanches() {
        carregadorDados = new CarregadorLanchesTeste();
    }

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_lanches, container, false);
        configurarListaLanches(view);
        return view;
    }

    private void configurarListaLanches(View view) {
        ListView listaLanches = (ListView) view.findViewById(R.id.lista_lanches);
        ArrayAdapter adapterEstabelecimentos = new AdapterLanches(carregadorDados);
        listaLanches.setAdapter(adapterEstabelecimentos);
    }

    private class AdapterLanches extends ArrayAdapter<Produto> {

        public AdapterLanches(CarregadorDados<Produto> carregadorDados) {
            super(getActivity(), 0);
            addAll(carregadorDados.getDados());
        }

        @Override
        public View getView(int position, View viewLanche, ViewGroup parent) {
            Produto produto = getItem(position);
            if (viewLanche == null) {
                viewLanche = LayoutInflater.from(getContext()).inflate(R.layout.item_produto, parent, false);
                TextView nomeProduto = (TextView) viewLanche.findViewById(R.id.nome_estabelecimento);
                TextView descricao = (TextView) viewLanche.findViewById(R.id.endereco_estabelecimento);
                nomeProduto.setText(produto.getNome());
                descricao.setText(produto.getDescricao());
                configurarClick(viewLanche);
            }
            return viewLanche;
        }

        private void configurarClick(View convertView) {
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamar(PainelPedirLanche.class);
                }
            });
        }
    }
}
