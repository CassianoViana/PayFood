package framework;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public abstract class Tela extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
