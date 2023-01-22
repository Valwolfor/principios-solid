package single_responsability_and_SOLID.controller;

import single_responsability_and_SOLID.data_access.UsuariosDB;
import single_responsability_and_SOLID.beans.Usuario;

/**
 * Busca llevar registro de los proceso realizados. Extiende la funcionalidad de agregar y
 * eliminar de la BD.
 * Es un decorador.
 */
public class UsuariosData extends Usuarios {
    private int insertions;
    private int deletions;

    public UsuariosData(UsuariosDB usuariosBD) {
        super(usuariosBD);
    }

    /**
     * Retorna los usuarios impresos en pantalla.
     */
    @Override
    public void getAll() {
        super.getAll();
    }

    /**
     * Verifica la existencia del usuario, limitando los falsos positivos de inserciones. Luego
     * envía al super si no está el usuario. Incrementa el número de inserciones.
     * @param newUsuario Nuevo Usuario a agregar.
     */
    @Override
    public void addUser(Usuario newUsuario) {
        if (super.getUser(newUsuario.getNombreUsuario()) != null) {
            return;
        }

        super.addUser(newUsuario);
        insertions++;
    }

    /**
     * Verifica usuario por nombre de usuario. y lo retorna.
     * @param username String nombre que se desea obtener.
     * @return Objeto Usuario o null.
     */
    @Override
    public Usuario getUser(String username) {
        return super.getUser(username);
    }

    /**
     * Verifica la existencia de usuario y envía en caso de ser verdadero y controla los falsos
     * positivos de eliminaciones. Gestiona mensaje de usuario ya existente ne caso contrario.
     * @param username Nombre de usuario de objeto Usuario a eliminar.
     */
    @Override
    public void deleteUser(String username) {
        if (super.getUser(username) != null) {
            super.deleteUser(username);
            deletions++;
            return;
        }
        System.out.println("El usuario no existe en la BD, no se puede ejecutar la eliminación: " + username);
    }

    public void getData(){
        System.out.println("Total de inserciones fueron: " + getInsertions() + "\r\n " +
                "Total de eliminaciones: " + getDeletions());
    }

    public int getInsertions() {
        return insertions;
    }

    public int getDeletions() {
        return deletions;
    }
}
