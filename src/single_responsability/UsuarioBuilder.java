package single_responsability;

/**
 * Constructor de usuario.
 * @author BMO
 */
public class UsuarioBuilder {
    private Usuario usuario;

    private UsuarioBuilder(){

    }
    public UsuarioBuilder(String sNombreUsuario) {
        usuario = new Usuario();
        usuario.setNombreUsuario(sNombreUsuario);
    }

    public UsuarioBuilder setNombre(String sNombre){
        usuario.setNombre(sNombre);
        return this;
    }

    public UsuarioBuilder setApellidos(String sApellidos){
        usuario.setApellidos(sApellidos);
        return this;
    }
    public UsuarioBuilder setEmail(String sEmail){
        usuario.setEmail(sEmail);
        return this;
    }
    public UsuarioBuilder setNivelDeAcceso(int sNivel){
        usuario.setNivelAcceso(sNivel);
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}