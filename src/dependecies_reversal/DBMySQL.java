package dependecies_reversal;

public class DBMySQL implements DBStore{

    @Override
    public void guardar(Usuario usuario) {
        System.out.println("Guardando en DBMySQL");
    }
}
