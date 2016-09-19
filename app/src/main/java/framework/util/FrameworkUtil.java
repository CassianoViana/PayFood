package framework.util;


import android.content.Context;

import com.payfood.payfood.procurandoLanche.estabelecimentos.estabelecimento.lanches.lanche.TelaLanche;

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


}
