package framework.util;


import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;

import com.payfood.payfood.R;
import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche.TelaLanche;

import framework.Tela;

public class FrameworkUtil {

    private static FrameworkUtil frameworkUtil;
    private MessageUtil messageUtil;

    private FrameworkUtil() {
        messageUtil = MessageUtilImpl.instance();
    }

    public static FrameworkUtil instance() {
        if (frameworkUtil == null)
            frameworkUtil = new FrameworkUtil();
        return frameworkUtil;
    }

    // manipulacao de erros

    public void manipularErro(Context context, Throwable e) {
        messageUtil.mostrarErro(context, e);
        e.printStackTrace();
    }


    public static void setUpToolbar(Tela view, String title) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        view.setSupportActionBar(toolbar);
        view.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void showMessage(Context context, int idTitle, int idMensagem) {
        new AlertDialog.Builder(context).setTitle(idTitle).setMessage(idMensagem).show();
    }
}
