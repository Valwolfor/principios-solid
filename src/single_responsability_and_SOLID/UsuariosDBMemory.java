package single_responsability_and_SOLID;

import java.util.ArrayList;

/**
 * Guarda los usuario en memoria en vez de un archivo de txt.
 */
public class UsuariosDBMemory extends UsuariosDB {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    /**
     * Agrega usuario al array.
     *
     * @param newUsuario Objeto Usuario a agregar.
     */
    @Override
    public void addUser(Usuario newUsuario) {
        usuarios.add(newUsuario);
    }

    /**
     * Verifica la existencia del elemento con el nombre de usuario y lo devuelve.
     *
     * @param username Nombre de usuario que se desea buscar.
     * @return Objeto Usuario en caso de encontrarse, null en caso contrario.
     */
    @Override
    public Usuario verificarUsuario(String username) {
        for (Usuario usuario : usuarios) {
            String nombreActual = usuario.getNombreUsuario();
            if (nombreActual.equalsIgnoreCase(username)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Elimina el usuario en caso de existir.
     *
     * @param username Nombre de usuario a eliminar.
     */
    @Override
    public void deleteUser(String username) {
        Usuario usuario = verificarUsuario(username);
        if (usuario != null) {
            usuarios.remove(usuario);
            return;
        }

        System.out.println("El usuario no existe en el registro.");
    }

    /**
     * Retorna todos los usuarios.
     *
     * @return ArrayList de Usuario(s).
     */
    @Override
    public ArrayList<Usuario> obtenerArrayUsuarios() {
        return usuarios;
    }


}
