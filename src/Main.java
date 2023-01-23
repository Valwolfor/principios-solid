import single_responsability_and_SOLID.services.UsuarioBuilder;
import single_responsability_and_SOLID.services.UsuariosService;
import single_responsability_and_SOLID.repositories.UsuariosDB;
import single_responsability_and_SOLID.repositories.UsuariosDBMemory;
import single_responsability_and_SOLID.repositories.UsuariosDBTxt;
import single_responsability_and_SOLID.services.UsuariosNivel;

/**
 * @author : @vroman
 * OpenBootCamp code.
 * @see <a href="https://github.com/Open-Bootcamp/java_avanzado/tree/master/sesiones_19_20_21/src/Sesion21/Inicial">...</a>
 */
public class Main {
    /**
     * La arquitectura limplia busca que los programa sean lo menos acomplados, lo más faciles de
     * modificar o ampliar. La arquitectura limplia implementa un método por capas en dónde cáda
     * capa solo tendrá accesos a sus capa directamente superior e inferior, pero nunca más de
     * dos capas. Para aplicar la mejor forma se debe aplicar los principios SOLID.
     *
     * @param args contiene la clave valor del usuario por defecto que se debe agregar.
     * @author Valwolfor
     */
    public static void main(String[] args) {
        UsuariosDB usuariosDB = factoryUsuarioDB("texto");
        UsuariosService usuariosService = new UsuariosService(usuariosDB);

        usuariosService.addUser(new UsuarioBuilder(args[1])
                .setNombre(args[3])
                .setApellidos(args[5])
                .setEmail(args[7])
                .setNivelDeAcceso(Integer.parseInt(args[9]))
                .getUsuario()
        );

        System.out.println("Se creo el primer usuario, el por argumentos.");

        usuariosService.addUser(new UsuarioBuilder("openbootcamp")
                .setNombre("Open")
                .setApellidos("Bootcamp")
                .setEmail("ejemplos@open-bootcamp.com")
                .setNivelDeAcceso(10)
                .getUsuario()
        );

        System.out.println("Se creo segundo usuario por método.");

        usuariosService.addUser(new UsuarioBuilder("openbootcamp2")
                .setNombre("Open2")
                .setApellidos("Bootcamp2")
                .setEmail("ejemplos2@open-bootcamp.com")
                .setNivelDeAcceso(8)
                .getUsuario()
        );

        System.out.println("Se creo tercer usuario por método.");

        usuariosService.addUser(new UsuarioBuilder("openbootcamp3")
                .setNombre("Open3")
                .setApellidos("Bootcamp3")
                .setEmail("ejemplos3@open-bootcamp.com")
                .setNivelDeAcceso(1)
                .getUsuario()
        );

        System.out.println("Se creo cuarto usuario por método.");

        usuariosService.addUser(new UsuarioBuilder("openbootcamp3")
                .setNombre("Open3")
                .setApellidos("Bootcamp3")
                .setEmail("ejemplos3@open-bootcamp.com")
                .setNivelDeAcceso(5)
                .getUsuario()
        );

        System.out.println("Se intentó agregar cuarto usuario de nuevo.");

        usuariosService.getAll();

        System.out.println("\n" + usuariosService.getUser("Valwolfor").getNombreUsuario() + "\n");

        usuariosService.deleteUser("openbootcamp");

        usuariosService.getAll();

        usuariosService.deleteUser("openbootcamp");

        UsuariosNivel usuariosLvl = new UsuariosNivel(usuariosService);
        System.out.println("=============================================");

        usuariosLvl.isAdmin(usuariosService.getUser("Valwolfor"));
        usuariosLvl.isStudent(usuariosService.getUser("openbootcamp2"));
        usuariosLvl.isGuest(usuariosService.getUser("openbootcamp3"));


        mostrarEstadisticas(usuariosDB);

    }

    public static void mostrarEstadisticas(UsuariosDB usarioDB) {
        if (usarioDB instanceof UsuariosDBMemory) {
            System.out.println("Los datos desde memoria");
            ((UsuariosDBMemory) usarioDB).getData();
        } else {
            System.out.println("Los datos desde archivo de texto");
            ((UsuariosDBTxt) usarioDB).getData();
        }
    }

    public static UsuariosDB factoryUsuarioDB(String metodo) {
        if (metodo.equalsIgnoreCase("memoria")) {
            System.out.println("Se selecionó el método por memoria.");
            return new UsuariosDBMemory();
        } else if (metodo.equalsIgnoreCase("texto")) {
            System.out.println("Se selecionó el método por archivo de texto.");
            return new UsuariosDBTxt();
        } else {
            System.out.println("Ingrese un método valido, por favor.");
        }
        return null;
    }
}

