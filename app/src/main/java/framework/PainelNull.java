package framework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PainelNull extends Painel {
    @Override
    protected View aoCriar(LayoutInflater inflater, ViewGroup container) {
        return new LinearLayout(getActivity());
    }
}
