package framework;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.payfood.payfood.R;

public class TelaComToolbar extends Tela {

    private Toolbar toolbar;
    private FrameLayout conteudo;

    @Override
    protected void aoCriar() {
        setContentView(R.layout.framework_activity_com_barra);
        obterComponentesDoLayout();
        configurarTitulo();
        configurarConteudo();
    }

    private void obterComponentesDoLayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        conteudo = (FrameLayout) findViewById(R.id.conteudo_centro_drawer);
    }

    private void configurarTitulo() {
        if (toolbar != null) {
            toolbar.setTitle(getTitulo());
        }
    }

    protected String getTitulo() {
        return getString(R.string.titulo);
    }

    private void configurarConteudo() {
        conteudo.removeAllViews();
        conteudo.addView(getConteudo());
    }

    protected View getConteudo() {
        return new View(this);
    }
}
