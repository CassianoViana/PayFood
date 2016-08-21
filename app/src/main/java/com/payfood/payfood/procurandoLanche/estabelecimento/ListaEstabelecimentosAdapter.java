package com.payfood.payfood.procurandoLanche.estabelecimento;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;

import java.util.List;

public class ListaEstabelecimentosAdapter extends RecyclerView.Adapter<ListaEstabelecimentosAdapter.ViewHolder> {

    private List<Estabelecimento> estabelecimentos;

    public ListaEstabelecimentosAdapter(List<Estabelecimento> estabelecimentos){
        this.estabelecimentos = estabelecimentos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lanchonete, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.txtNome = (TextView) v.findViewById(R.id.nome_estabelecimento);
        viewHolder.txtEndereco = (TextView) v.findViewById(R.id.endereco_estabelecimento);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Estabelecimento estabelecimento = estabelecimentos.get(position);
        holder.txtNome.setText(estabelecimento.getNome());
        holder.txtEndereco.setText(estabelecimento.getEndereco());
    }

    @Override
    public int getItemCount() {
        return estabelecimentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView txtNome;
        public TextView txtEndereco;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
