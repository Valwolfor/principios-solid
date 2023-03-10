package single_responsability_and_SOLID.repositories;

import single_responsability_and_SOLID.entities.Usuario;

import java.util.ArrayList;

/**
 * Está clase podría no ser abstracta y aun así funcionaría el código al inyectarla.
 */
 abstract public class UsuariosDB {

    public abstract ArrayList<Usuario> obtenerArrayUsuarios();

    public abstract void addUser(Usuario newUsuario);

    public abstract void deleteUser(String username);

    public abstract Usuario verificarUsuario(String username);



}
