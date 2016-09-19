package framework.util;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.payfood.payfood.R;

import framework.Tela;

public class TelaErro extends Tela {

    TextView msg1, msg2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_erro);

        msg1 = (TextView) findViewById(R.id.mensagem_erro_curta);
        msg2 = (TextView) findViewById(R.id.mensagem_erro_longa);

        Throwable e = (Throwable) getIntent().getSerializableExtra("erro");

        msg1.setText("Oops...");
        msg2.setText(e.getMessage());
    }
}
