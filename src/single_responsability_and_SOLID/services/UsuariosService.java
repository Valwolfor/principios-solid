package single_responsability_and_SOLID.services;

import single_responsability_and_SOLID.entities.Usuario;
import single_responsability_and_SOLID.repositories.UsuariosDB;

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
//@Service
public class UsuariosService {
    private UsuariosDB usuariosBD;
    private ArrayList<Usuario> usuarios;

    public UsuariosService(UsuariosDB usuariosBD) {
        this.usuariosBD = usuariosBD;
    }

    /**
     * Imprime los usuarios en el archivo, que obtiene de la BD.
     */
    public ArrayList<Usuario> getAll() {
        return usuariosBD.obtenerArrayUsuarios();
    }

    /**
     * Lista los usuarios y compara si el nombre del usuario existe en el registro y lo retorna.
     *
     * @param sUsername String nombre que se desea obtener.
     * @return un objeto tipo Usuario del si existe el nombre de usuario pasado por parametro, en
     * caso contrario returna null.
     */
    public Usuario getUser(String sUsername) {
        return usuariosBD.verificarUsuario(sUsername);
    }

    /**
     * Verica la existencia del usuario de ser falso lo integra al archivo.
     *
     * @param newUsuario Objeto de Usuario que se ingresa en el archivo.
     */
    public void addUser(Usuario newUsuario) {
        usuariosBD.addUser(newUsuario);
    }

    /**
     * Verifica la existencia del objeto, lo elimina y actualiza en el archivo.
     *
     * @param username Nombre de usuario de Usuario a eliminar.
     */
    public void deleteUser(String username) {
        usuariosBD.deleteUser(username);
    }


    public UsuariosDB getUsuariosBD() {
        return this.usuariosBD;
    }
}
