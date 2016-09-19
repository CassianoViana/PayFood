package framework.userAccountManagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.payfood.payfood.entidades.Usuario;

import java.util.Date;

import framework.Tela;

public class LoginManagerImpl implements LoginManager {

    private final SharedPreferences preferences;
    private Tela context;

    public LoginManagerImpl(Tela context) {
        this.context = context;
        preferences = context.getSharedPreferences("usuarios_logados", Context.MODE_PRIVATE);
    }

    @Override
    public boolean usuarioEstaLogado() {
        String ultimo_login = preferences.getString("ultimo_login", null);
        boolean usuarioEstaLogado = preferences.contains(ultimo_login);
        return usuarioEstaLogado;
    }

    @Override
    public void logar(Usuario usuario, int requestCode) {

    }

    @Override
    public void salvar(Usuario usuario) {
        preferences.edit().putString(usuario.getEmail(), "Logado desde " + new Date().toString()).commit();
        preferences.edit().putString("ultimo_login", usuario.getEmail()).commit();
    }
}
