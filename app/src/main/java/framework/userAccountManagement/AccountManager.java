package framework.userAccountManagement;

import com.payfood.payfood.entidades.Usuario;

public interface AccountManager {
    boolean usuarioEstaLogado();
    Usuario getUsuarioLogado();
    void salvar(Usuario usuario);
    void registrar(int requestCode);
    void logout();
}
