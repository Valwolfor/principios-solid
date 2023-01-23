package single_responsability_and_SOLID.data_access;

/**
 * Busca llevar registro de los proceso realizados. Extiende la funcionalidad de agregar y
 * eliminar de la BD.
 * Es un decorador.
 */
public interface UsuariosDBData {
    int insertions = 0;
    int deletions = 0;

    void getData();

    int getInsertions();

    int getDeletions();
}
