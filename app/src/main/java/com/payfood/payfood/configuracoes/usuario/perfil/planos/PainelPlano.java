package com.payfood.payfood.configuracoes.usuario.perfil.planos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.FuncionalidadePlano;
import com.payfood.payfood.entidades.Plano;

import framework.Painel;
import lombok.Setter;

@Setter
public class PainelPlano extends Painel {

    private ListView itensPlano;
    private TextView tituloPlano;
    private Plano plano;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plano, container, false);
        itensPlano = (ListView) view.findViewById(R.id.itens_plano);
        tituloPlano = (TextView) view.findViewById(R.id.titulo_plano);

        tituloPlano.setText(plano.getNome());
        itensPlano.setAdapter(makeAdapter());

        return view;
    }

    @NonNull
    private ArrayAdapter<FuncionalidadePlano> makeAdapter() {
        return new ArrayAdapter<FuncionalidadePlano>(getActivity(), R.layout.item_funcionalidade_plano, plano.getFuncionalidades()) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View inflatedView = LayoutInflater.from(getActivity()).inflate(R.layout.item_funcionalidade_plano, parent, false);
                ((TextView) inflatedView.findViewById(R.id.descricao_item_plano)).setText(getItem(position).getDescricao());
                return inflatedView;
            }
        };
    }

    public static Painel criar(Plano plano) {
        PainelPlano painelPlano = new PainelPlano();
        painelPlano.setPlano(plano);
        return painelPlano;
    }
}
