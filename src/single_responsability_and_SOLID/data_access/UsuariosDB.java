package single_responsability_and_SOLID.data_access;

import single_responsability_and_SOLID.beans.Usuario;

import java.util.ArrayList;

abstract public class UsuariosDB {

    public abstract ArrayList<Usuario> obtenerArrayUsuarios();

    public abstract void addUser(Usuario newUsuario);

    public abstract void deleteUser(String username);

    public abstract Usuario verificarUsuario(String username);



}
