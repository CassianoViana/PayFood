package framework.userAccountManagement;


import com.payfood.payfood.entidades.Usuario;

public interface VerificadorConta {
    boolean jaTemConta(Usuario usuario);
    void registrar(int requestCode);
}
