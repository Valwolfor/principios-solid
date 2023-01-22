package cleaning;

import java.util.ArrayList;

/**
 * Gestiona el manejo de los objetos Usuarios.
 * <p>
 * Agregandolos al archivo de texto, lista todos los usuarios, eliminandolos y verificando su
 * existencia.
 *
 * @author @vroman
 * OpenBootCamp code.
 * Editor: @Valwolfor
 * @see <a href="https://github.com/Open-Bootcamp/java_avanzado/tree/master/sesiones_19_20_21/src/Sesion21/Inicial">Repositorio</a>
 */
public class Usuarios {
    private UsuariosDB usuariosBD = new UsuariosDB();
    private ArrayList<Usuario> usuarios;

    /**
     * Imprime los usuarios en el archivo, que obtiene de la BD.
     */
    public void getAll() {
        for (Usuario usuario : usuariosBD.parseToArrayUsuario()) {
            System.out.println("======================================================");
            System.out.println("Nombre de Usuario: " + usuario.getNombreUsuario() +
                    "\n Nombre: " + usuario.getNombre() +
                    "\n Apellidos: " + usuario.getApellidos() +
                    "\n Correo: " + usuario.getEmail() +
                    "\n Nivel de acceso: " + usuario.getNivelAcceso()
            );
        }
    }

    /**
     * Lista los usuarios y compara si el nombre del usuario existe en el registro y lo retorna.
     *
     * @param sUsername String nombre que se desea obtener.
     * @return un objeto tipo Usuario del si existe el nombre de usuario pasado por parametro, en
     * caso contrario returna null.
     */
    public Usuario getUsuario(String sUsername) {
        return usuariosBD.verificarUsuario(sUsername);
    }

    /**
     * Verica la existencia del usuario de ser falso lo integra al archivo.
     *
     * @param newUsuario Objeto de Usuario que se ingresa en el archivo.
     */
    public void create(Usuario newUsuario) {
        usuariosBD.addUser(newUsuario);
    }

    /**
     * Verifica la existencia del objeto, lo elimina y actualiza en el archivo.
     *
     * @param username Nombre de usuario de Usuario a eliminar.
     */
    public void delete(String username) {
        usuariosBD.deleteUsuario(username);
    }
}
