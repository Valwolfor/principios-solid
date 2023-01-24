package single_responsability_and_SOLID.repositories;

public class UsuariosDBFactory {
    String tipoBD = "";

    public UsuariosDBFactory(String tipoBD) {
        this.tipoBD = tipoBD;
    }

    public UsuariosDB databaseInstance() {
        if (tipoBD.equalsIgnoreCase("memoria")) {
            System.out.println("Se selecionó el método por memoria.");
            return new UsuariosDBMemory();

        } else if (tipoBD.equalsIgnoreCase("texto")) {
            System.out.println("Se selecionó el método por archivo de texto.");
            return new UsuariosDBTxt();

        } else {
            System.out.println("Ingrese un método valido, por favor.");
        }
        return null;
    }
}
