package framework.userAccountManagement;


import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.exceptions.UserAccountException;
import framework.userAccountManagement.exceptions.UsuarioNaoLogadoException;

public class GerenciadorUsuario {

    static GerenciadorUsuario gerenciadorUsuario;
    static Usuario usuario;

    AccountManager accountManager;
    private boolean estaLogado;


    public static GerenciadorUsuario instance(Tela tela) {
        if (gerenciadorUsuario == null)
            gerenciadorUsuario = new GerenciadorUsuario();
        gerenciadorUsuario.accountManager = new AccountManagerImpl(tela);
        usuario = gerenciadorUsuario.accountManager.getUsuarioLogado();
        return gerenciadorUsuario;
    }

    private GerenciadorUsuario() {

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean estaLogado() {
        this.estaLogado = accountManager.usuarioEstaLogado();
        return estaLogado;
    }

    public boolean verify() throws UserAccountException {
        if (!estaLogado)
            throw new UsuarioNaoLogadoException();
        return true;
    }

    public void registrar(int requestCode) {
        accountManager.registrar(requestCode);
    }

    public void salvarUsuario(Usuario usuarioSalvar) {
        usuario = usuarioSalvar;
        estaLogado = true;
        accountManager.salvar(usuario);
    }
}
