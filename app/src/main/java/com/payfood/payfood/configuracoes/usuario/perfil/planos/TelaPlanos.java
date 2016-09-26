package com.payfood.payfood.configuracoes.usuario.perfil.planos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.payfood.payfood.R;
import com.payfood.payfood.entidades.FuncionalidadePlano;
import com.payfood.payfood.entidades.Plano;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import framework.Tela;
import framework.niceUiComponents.SwipeBalls;
import framework.util.FrameworkUtil;

public class TelaPlanos extends Tela {

    ViewPager pager;
    SwipeBalls swipeBalls;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_planos);

        List<Plano> planos = getPlanos(getIntent());

        pager = (ViewPager) findViewById(R.id.pager_planos);
        PagerPlanosAdapterBuilder planosAdapterBuilder = new PagerPlanosAdapterBuilder(this, planos);
        pager.setAdapter(planosAdapterBuilder.getAdapter());

        swipeBalls = new SwipeBalls(this, pager);
        swipeBalls.setItens(planos.size());
        swipeBalls.activePosition(0);

        FrameworkUtil.setUpToolbar(this, getResources().getString(R.string.assinatura_app));
    }

    private List<Plano> getPlanos(Intent intent) {
        List<Plano> planos = new ArrayList<>();
        planos.add(new Plano("Semanal", Arrays.asList(new FuncionalidadePlano[]{new FuncionalidadePlano("Desconto de 50%", true), new FuncionalidadePlano("Desconto de 90%", false)})));
        planos.add(new Plano("Mensal", Arrays.asList(new FuncionalidadePlano[]{new FuncionalidadePlano("Desconto de 50%", true)})));
        planos.add(new Plano("Anual", Arrays.asList(new FuncionalidadePlano[]{new FuncionalidadePlano("Desconto de 50%", true)})));
        return planos;
    }
}
