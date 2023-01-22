package single_responsability_and_SOLID;

/**
 * La clase que agrupa los elementos de cada usuario. Implementa un patrón builder.
 * @author : @vroman
 * Editor: @Valwofor
 * OpenBootCamp code.
 * @see
 * <a href="https://github.com/Open-Bootcamp/java_avanzado/tree/master/sesiones_19_20_21/src/Sesion21/Inicial">Respositorio</a>
 */
public class Usuario {
    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String email = "";
    private int nivelAcceso;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }


}
