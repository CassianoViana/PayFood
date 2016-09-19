package framework.userAccountManagement;

import com.payfood.payfood.entidades.Usuario;

public interface LoginManager {
    boolean usuarioEstaLogado();
    void logar(Usuario usuario, int requestCode);
    void salvar(Usuario usuario);
}
