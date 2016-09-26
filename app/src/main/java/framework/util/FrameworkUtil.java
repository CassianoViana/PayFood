package framework.util;


import android.content.Context;
import android.support.v7.widget.Toolbar;

import com.payfood.payfood.R;

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
    }


    public static void setUpToolbar(Tela view, String title) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        view.setSupportActionBar(toolbar);
        view.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
