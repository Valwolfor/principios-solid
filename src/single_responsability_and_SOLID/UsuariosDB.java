package single_responsability_and_SOLID;

import java.util.ArrayList;

abstract public class UsuariosDB {

    abstract ArrayList<Usuario> obtenerArrayUsuarios();

    abstract void addUser(Usuario newUsuario);

    abstract void deleteUser(String username);

    abstract Usuario verificarUsuario(String username);



}
