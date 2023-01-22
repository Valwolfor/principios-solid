package single_responsability_and_SOLID;

/**
 * Busca llevar registro de los proceso realizados. Extiende la funcionalidad de agregar y
 * eliminar de la BD.
 */
public class UsuariosDBData extends UsuariosDB {
    private int insertions;
    private int deletions;

    /**
     * Verifica la existencia del usuario, limitando los falsos positivos de inserciones. Luego
     * envía al super si no está el usuario. Incrementa el número de inserciones.
     * @param newUsuario Nuevo Usuario a agregar.
     */
    @Override
    public void addUser(Usuario newUsuario) {
        if (super.verificarUsuario(newUsuario.getNombreUsuario()) != null) {
            return;
        }
        super.addUser(newUsuario);



        insertions++;
    }

    /**
     * Verifica la existencia de usuario y envía en caso de ser verdadero y controla los falsos
     * positivos de eliminaciones. Gestiona mensaje de usuario ya existente ne caso contrario.
     * @param username Nombre de usuario de objeto Usuario a eliminar.
     */
    @Override
    public void deleteUsuario(String username) {
        if (super.verificarUsuario(username) != null) {
            super.deleteUsuario(username);
            deletions++;
            return;
        }
        System.out.println("El usuario no existe en la BD, no se puede ejecutar la eliminación: " + username);
    }

    public void getData(){
        System.out.println("Total de inserciones fueron: " + getInsertions() + "\r\n " +
                "Total de " +
                "eliminaciones: " + getDeletions());
    }

    public int getInsertions() {
        return insertions;
    }

    public int getDeletions() {
        return deletions;
    }
}
