package com.payfood.payfood.telaPrincipal;


import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.payfood.payfood.R;

import framework.Tela;

public class MenuLateral {

    private final Tela context;
    private ListView listaMenuLateral;
    private ListenerItemClick listenerItemClick;

    public MenuLateral(Tela context) {
        this.context = context;
        listenerItemClick = (ListenerItemClick) context;
        listaMenuLateral = (ListView) context.findViewById(R.id.lista_menu_lateral);
        montarLista();
    }

    class Item {
        String nome;
        int icRs;
        String fragmentName;

        public Item(String nome, int icRs, String fragmentName) {
            this.nome = nome;
            this.icRs = icRs;
            this.fragmentName = fragmentName;
        }
    }

    private void montarLista() {

        final String nomes[] = context.getResources().getStringArray(R.array.menu_principal_array);
        final TypedArray icones = context.getResources().obtainTypedArray(R.array.menu_principal_icones);
        final String fragmentNames[] = context.getResources().getStringArray(R.array.menu_principal_fragment_names);

        final ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(context, R.layout.drawer_list_item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = LayoutInflater.from(context).inflate(R.layout.drawer_list_item, parent, false);
                Item item = getItem(position);
                ImageView icone = (ImageView) view.findViewById(R.id.icone_menu);
                icone.setImageResource(item.icRs);
                TextView nome = (TextView) view.findViewById(R.id.nome_menu);
                nome.setText(item.nome);
                return view;
            }
        };

        for (int i = 0; i < nomes.length; i++)
            adapter.add(new Item(nomes[i], icones.getResourceId(i, 1), fragmentNames[i]));

        listaMenuLateral.setAdapter(adapter);

        // Listener click

        listaMenuLateral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {
                clicar(posicao);
            }
        });
    }

    public void clicar(int i){
        listaMenuLateral.setItemChecked(i, true);
        listenerItemClick.clicou((Item) listaMenuLateral.getAdapter().getItem(i));
    }

    public interface ListenerItemClick {
        void clicou(Item itemMenu);
    }

}
