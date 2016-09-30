package com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.Produto;

import java.util.List;

import minhaLang.Util;

public class ListaLanchesAdapter extends RecyclerView.Adapter<ListaLanchesAdapter.ViewHolder> {

    private Context context;
    private List<Produto> lanches;
    private Listener listener;

    public ListaLanchesAdapter(List<Produto> lanches, Context context, Listener listener) {
        this.listener = listener;
        this.lanches = lanches;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.nomeProduto = (TextView) view.findViewById(R.id.nome_lanche);
        viewHolder.descricaoProduto = (TextView) view.findViewById(R.id.descricao_lanche);
        viewHolder.imagemLanche = (ImageView) view.findViewById(R.id.imagem_lanche);
        viewHolder.precoLanche = (TextView) view.findViewById(R.id.preco_produto);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Produto produto = lanches.get(position);
        holder.nomeProduto.setText(produto.getNome());
        holder.descricaoProduto.setText(produto.getDescricao());
        holder.precoLanche.setText(produto.getPrecoFormatado());
        Util.glidImage(holder.imagemLanche, produto.getImgUrl(), context, R.drawable.ic_local_pizza_black_24dp);
        holder.bind(produto, listener);
    }

    @Override
    public int getItemCount() {
        return lanches.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto;
        TextView descricaoProduto;
        ImageView imagemLanche;
        TextView precoLanche;

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(final Produto produto, final Listener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.aoClicarEmProdutoDoAdapter(produto);
                }
            });
        }
    }

    public interface Listener {
        void aoClicarEmProdutoDoAdapter(Produto produto);
    }
}