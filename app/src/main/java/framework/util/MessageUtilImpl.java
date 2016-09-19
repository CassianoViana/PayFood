package framework.util;

import android.content.Context;
import android.content.Intent;

public class MessageUtilImpl implements MessageUtil {

    private static MessageUtilImpl messageUtil;

    public static MessageUtil instance() {
        if (messageUtil == null)
            messageUtil = new MessageUtilImpl();
        return messageUtil;
    }

    @Override
    public void mostrarErro(Context context, Throwable e) {
        Intent intent = new Intent(context, TelaErro.class);
        intent.putExtra("erro", e);
        context.startActivity(intent);
    }
}
