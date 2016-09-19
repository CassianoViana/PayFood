package framework.userAccountManagement;


import com.payfood.payfood.entidades.Usuario;

import framework.Tela;
import framework.userAccountManagement.exceptions.UserAccountException;
import framework.userAccountManagement.exceptions.UsuarioNaoLogadoException;

public class GerenciadorUsuario {

    static GerenciadorUsuario gerenciadorUsuario;
    static Usuario usuario;

    VerificadorConta verificadorConta;
    LoginManager loginManager;
    private boolean jaTemConta;
    private boolean estaLogado;


    public static GerenciadorUsuario instance(Tela tela) {
        if (gerenciadorUsuario == null)
            gerenciadorUsuario = new GerenciadorUsuario();
        gerenciadorUsuario.verificadorConta = new VerificadorContaImpl(tela);
        gerenciadorUsuario.loginManager = new LoginManagerImpl(tela);
        return gerenciadorUsuario;
    }

    private GerenciadorUsuario() {


    }

    public GerenciadorUsuario jaTemConta() {
        this.jaTemConta = verificadorConta.jaTemConta(usuario);
        return this;
    }

    public boolean estaLogado() {
        this.estaLogado = loginManager.usuarioEstaLogado();
        return estaLogado;
    }

    public boolean verify() throws UserAccountException {
        if (!estaLogado)
            throw new UsuarioNaoLogadoException();
        return true;
    }

    public void logar(int requestCode) {
        loginManager.logar(usuario, requestCode);
    }

    public void registrar(int requestCode) {
        verificadorConta.registrar(requestCode);
    }

    public void salvarUsuario(Usuario usuarioSalvar) {
        usuario = usuarioSalvar;
        estaLogado = true;
        loginManager.salvar(usuario);
    }
}
