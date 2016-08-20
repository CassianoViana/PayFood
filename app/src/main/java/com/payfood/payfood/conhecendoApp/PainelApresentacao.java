package com.payfood.payfood.conhecendoApp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.payfood.payfood.R;
import com.payfood.payfood.entrandoComoUsuario.PainelValidacaoEmail;
import com.payfood.payfood.telaPrincipal.DashBoard;

import framework.Painel;

public class PainelApresentacao extends Painel {

    private Button btnConhecer, btnJaTenhoConta;

    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_apresentacao, container, false);
        associarComponentes(view);
        configurarEventos();
        return view;
    }

    private void configurarEventos() {
        btnConhecer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sairDaPilha();
                chamar(DashBoard.class);
            }
        });
        btnJaTenhoConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chamar(PainelValidacaoEmail.class);
            }
        });
    }

    private void associarComponentes(View view) {
        ViewPager pagerApresentacaoApp = (ViewPager) view.findViewById(R.id.tabs_apresentacao_app);
        if (pagerApresentacaoApp != null) {
            PagerAdapter adapter = new AdapterPagerTelaApresentacaoApp(this).getAdapter();
            pagerApresentacaoApp.setAdapter(adapter);
        }
        btnConhecer = (Button) view.findViewById(R.id.btn_conhecer);
        btnJaTenhoConta = (Button) view.findViewById(R.id.btn_ja_tenho_conta);
    }
}
