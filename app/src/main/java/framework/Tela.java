package framework;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

public abstract class Tela extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aoCriar();
        aoCriar(savedInstanceState);
    }

    protected void aoCriar(){}

    protected void aoCriar(Bundle estado){}
}
