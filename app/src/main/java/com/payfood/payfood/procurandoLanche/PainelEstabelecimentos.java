package com.payfood.payfood.procurandoLanche;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Lanchonete;

import framework.Painel;
import minhaLang.CarregadorDados;

public class PainelEstabelecimentos extends Painel {

    private ListView listaEstabelecimentos;
    private ArrayAdapter adapterEstabelecimentos;
    private CarregadorDados<Lanchonete> carregadorDados;

    public PainelEstabelecimentos() {
        carregadorDados = new CarregadorLanchonetesTeste();
    }

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_estabelecimentos, container, false);
        configurarListagemEstabelecimentos(view);
        return view;
    }

    private void configurarListagemEstabelecimentos(View view) {
        listaEstabelecimentos = (ListView) view.findViewById(R.id.lista_estabelecimentos);
        adapterEstabelecimentos = new AdapterEstabelecimentos(carregadorDados);
        listaEstabelecimentos.setAdapter(adapterEstabelecimentos);
    }

    private class AdapterEstabelecimentos extends ArrayAdapter<Lanchonete> {

        public AdapterEstabelecimentos(CarregadorDados<Lanchonete> carregadorDados) {
            super(getActivity(), 0);
            addAll(carregadorDados.getDados());
        }

        @Override
        public View getView(int position, View viewItemLanchonete, ViewGroup parent) {
            Lanchonete lanchonete = getItem(position);
            if (viewItemLanchonete == null) {
                viewItemLanchonete = LayoutInflater.from(getContext()).inflate(R.layout.item_lanchonete, parent, false);
                configurarClick(viewItemLanchonete);
            }
            TextView nomeEstabelecimento = (TextView) viewItemLanchonete.findViewById(R.id.nome_estabelecimento);
            TextView enderecoEstabelecimento = (TextView) viewItemLanchonete.findViewById(R.id.endereco_estabelecimento);
            nomeEstabelecimento.setText(lanchonete.getNome());
            enderecoEstabelecimento.setText(lanchonete.getEndereco());
            return viewItemLanchonete;
        }

        private void configurarClick(View viewEstabelecimento) {
            viewEstabelecimento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    chamar(PainelLanches.class);
                }
            });
        }
    }
}
