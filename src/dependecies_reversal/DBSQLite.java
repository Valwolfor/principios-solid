package dependecies_reversal;

public class DBSQLite implements DBStore{
    @Override
    public void guardar(Usuario usuario) {
        System.out.println("Guardando en SQLite");
    }
}
