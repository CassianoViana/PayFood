package framework.userAccountManagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.payfood.payfood.entidades.Usuario;
import com.payfood.payfood.entrandoComoUsuario.TelaCadastro;

import java.util.Date;

import framework.Tela;

public class AccountManagerImpl implements AccountManager {

    private final SharedPreferences preferences;
    private Tela context;

    public AccountManagerImpl(Tela context) {
        this.context = context;
        preferences = context.getSharedPreferences("usuarios_logados", Context.MODE_PRIVATE);
    }

    @Override
    public boolean usuarioEstaLogado() {
        String ultimo_login = preferences.getString("ultimo_login_email", null);
        boolean usuarioEstaLogado = preferences.contains(ultimo_login);
        return usuarioEstaLogado;
    }

    @Override
    public Usuario getUsuarioLogado() {
        if (usuarioEstaLogado()) {
            Usuario usuario = new Usuario();
            usuario.setEmail(preferences.getString("ultimo_login_email", null));
            usuario.setNome(preferences.getString("ultimo_login_nome", null));
            usuario.setId(preferences.getString("ultimo_login_id", null));
            return usuario;
        }
        return Usuario.NULL;
    }

    @Override
    public void registrar(int requestCode) {
        Intent activityCadastro = new Intent(context, TelaCadastro.class);
        context.startActivityForResult(activityCadastro, requestCode);
    }

    @Override
    public void logout() {
        preferences.edit().remove("ultimo_login_nome").commit();
        preferences.edit().remove("ultimo_login_email").commit();
        preferences.edit().remove("ultimo_login_id").commit();
    }

    @Override
    public void salvar(Usuario usuario) {
        preferences.edit().putString(usuario.getEmail(), "Logado desde " + new Date().toString()).commit();
        preferences.edit().putString("ultimo_login_nome", usuario.getNome()).commit();
        preferences.edit().putString("ultimo_login_email", usuario.getEmail()).commit();
        preferences.edit().putString("ultimo_login_id", usuario.getId()).commit();
    }
}
