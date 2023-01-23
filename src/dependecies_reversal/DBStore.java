package dependecies_reversal;

public interface DBStore {
    void guardar(Usuario usuario);
}

//Envoltorio para implementar(main)
/*
* void guardarBDWrapper(DBStore db, Usuario usuario){
*       db.guardar(usuario);
* }
* */
