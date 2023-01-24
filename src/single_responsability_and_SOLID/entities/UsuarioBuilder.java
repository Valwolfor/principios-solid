package single_responsability_and_SOLID.entities;

/**
 * Constructor de usuario.
 * @author BMO
 */
public class UsuarioBuilder {
    private final Usuario usuario = new Usuario();

    private UsuarioBuilder(){

    }
    public UsuarioBuilder(String sNombreUsuario) {
        usuario.setNombre("sin nombre");
        usuario.setApellidos("sin apellidos");
        usuario.setEmail("sin email");
        usuario.setNivelAcceso(0);

        usuario.setNombreUsuario(sNombreUsuario);
    }

    public UsuarioBuilder setNombre(String sNombre){
        usuario.setNombre(sNombre.length() > 0 ? sNombre: "sin nombre");
        return this;
    }

    public UsuarioBuilder setApellidos(String sApellidos){
        usuario.setApellidos(sApellidos.length() > 0 ? sApellidos: "sin apellidos");
        return this;
    }
    public UsuarioBuilder setEmail(String sEmail){
        usuario.setEmail(sEmail.length() > 0 ? sEmail: "sin email");
        return this;
    }
    public UsuarioBuilder setNivelDeAcceso(int sNivel){
        usuario.setNivelAcceso(sNivel > 0 ? sNivel: 0);
        return this;
    }

    public Usuario bulidUsuario() {
        return usuario;
    }


}