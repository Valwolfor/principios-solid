package single_responsability_and_SOLID.data_access;

import single_responsability_and_SOLID.beans.Usuario;

import java.util.ArrayList;

/**
 * Guarda los usuario en memoria en vez de un archivo de txt.
 */
public class UsuariosDBMemory implements UsuariosDB, UsuariosDBData {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private int insertions = 0;
    private int deletions = 0;

    /**
     * Agrega usuario en caso de no existir. Registra la inserción.
     * @param newUsuario Objeto Usuario a insertar.
     */
    @Override
    public void addUser(Usuario newUsuario) {
        Usuario existente = verificarUsuario(newUsuario.getNombreUsuario());
        if (existente == null) {
            usuarios.add(newUsuario);
            insertions++;
            return;
        }

        System.out.println("El usuario ingresado ya se encuentra registrado.");
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
            System.out.println("El usuario: " + username + " fue eliminado.");
            deletions++;
            return;
        }

        System.out.println("El usuario: " + username + " no existe.");
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

    /**
     * Devuelve las estadísticas de la implentación
     */
    @Override
    public void getData() {
        System.out.println("Total de inserciones fueron: " + insertions + "\r\n " +
                "Total de eliminaciones: " + deletions);
    }

    @Override
    public int getInsertions() {
        return insertions;
    }

    @Override
    public int getDeletions() {
        return deletions;
    }
}
