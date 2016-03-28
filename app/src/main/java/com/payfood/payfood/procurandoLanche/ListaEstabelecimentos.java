package com.payfood.payfood.procurandoLanche;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import framework.Lista;

public class ListaEstabelecimentos extends Lista {

    public ListaEstabelecimentos(Context context) {
        super(context);
    }

    @Override
    public ListAdapter getAdapter() {
        return new ArrayAdapter<String>(getContext(), 0);
    }
}
