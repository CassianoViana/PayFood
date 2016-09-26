package framework.userAccountManagement;

import com.payfood.payfood.entidades.Usuario;

public interface AccountManager {
    boolean usuarioEstaLogado();
    Usuario getUsuarioLogado();
    void logar(Usuario usuario, int requestCode);
    void salvar(Usuario usuario);
    void registrar(int requestCode);
}
