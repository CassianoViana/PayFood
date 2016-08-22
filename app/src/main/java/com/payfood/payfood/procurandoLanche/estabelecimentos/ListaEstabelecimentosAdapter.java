package com.payfood.payfood.procurandoLanche.estabelecimentos;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Estabelecimento;

import java.util.List;

import minhaLang.Util;

public class ListaEstabelecimentosAdapter extends RecyclerView.Adapter<ListaEstabelecimentosAdapter.ViewHolder> {

    private List<Estabelecimento> estabelecimentos;
    private Context context;
    private Listener listener;

    public ListaEstabelecimentosAdapter(List<Estabelecimento> estabelecimentos, Context context, Listener listener){
        this.estabelecimentos = estabelecimentos;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lanchonete, parent, false);
        final ViewHolder viewHolder = new ViewHolder(v);
        viewHolder.imgLogo = (ImageView) v.findViewById(R.id.logo_estabelecimento);
        viewHolder.txtNome = (TextView) v.findViewById(R.id.nome_estabelecimento);
        viewHolder.txtEndereco = (TextView) v.findViewById(R.id.endereco_estabelecimento);
        viewHolder.txtDesc = (TextView) v.findViewById(R.id.descricao_estabelecimento);
        viewHolder.ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Estabelecimento estabelecimento = estabelecimentos.get(position);
        holder.txtNome.setText(estabelecimento.getNome());
        holder.txtEndereco.setText(estabelecimento.getEndereco());
        holder.txtDesc.setText(estabelecimento.getDescricao());
        holder.ratingBar.setProgress(estabelecimento.getAvaliacao());
        Util.glidImage(holder.imgLogo, estabelecimento.getImgUrl(), context);
        holder.bind(estabelecimentos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return estabelecimentos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgLogo;
        public TextView txtNome;
        public TextView txtEndereco;
        public TextView txtDesc;
        public RatingBar ratingBar;

        public void bind(final Estabelecimento estabelecimento, final Listener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.itemAdapterFoiClicado(estabelecimento);
                }
            });
        }
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface Listener {
        void itemAdapterFoiClicado(Estabelecimento estabelecimento);
    }
}
