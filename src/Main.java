import single_responsability_and_SOLID.entities.Usuario;
import single_responsability_and_SOLID.repositories.UsuariosDBFactory;
import single_responsability_and_SOLID.services.UsuariosService;
import single_responsability_and_SOLID.repositories.UsuariosDB;
import single_responsability_and_SOLID.repositories.UsuariosDBMemory;
import single_responsability_and_SOLID.repositories.UsuariosDBTxt;
import single_responsability_and_SOLID.services.UsuariosNivel;

import java.util.function.Consumer;

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
        UsuariosService usuariosService = new UsuariosService("memoria");
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario();
        Usuario usuario3 = new Usuario();
        Usuario usuario4 = new Usuario();

        usuario1.setNombreUsuario(args[1]);
        usuario1.setNombre(args[3]);
        usuario1.setApellidos(args[5]);
        usuario1.setEmail(args[7]);
        usuario1.setNivelAcceso(Integer.parseInt(args[9]));

        usuariosService.addUser(usuario1);

        System.out.println("Se creo el primer usuario, el por argumentos.");

        usuario2.setNombreUsuario("openbootcamp");
        usuario2.setNombre("Open");
        usuario2.setApellidos("Bootcamp");
        usuario2.setEmail("ejemplos@open-bootcamp.com");
        usuario2.setNivelAcceso(10);

        usuariosService.addUser(usuario2);

        System.out.println("Se creo segundo usuario por método.");

        usuario3.setNombreUsuario("openbootcamp2");
        usuario3.setNombre("Open2");
        usuario3.setApellidos("Bootcamp2");
//        usuario3.setEmail("ejemplos2@open-bootcamp.com");
        usuario3.setNivelAcceso(7);

        usuariosService.addUser(usuario3);

        usuario4.setNombreUsuario("openbootcamp3");
        usuario4.setNombre("Open3");
        usuario4.setApellidos("Bootcamp3");
        usuario4.setEmail("ejemplos3@open-bootcamp.com");
        usuario4.setNivelAcceso(1);

        System.out.println("Se creo tercer usuario por método.");

        usuariosService.addUser(usuario4);

        System.out.println("Se creo cuarto usuario por método.");

        usuariosService.addUser(usuario4);

        System.out.println("Se intentó agregar cuarto usuario de nuevo.");

        System.out.println(usuariosService.getAll());

        System.out.println("\n" + usuariosService.getUser("Valwolfor").getNombreUsuario() + "\n");

        usuariosService.deleteUser("openbootcamp");

        System.out.println(usuariosService.getAll());

        usuariosService.deleteUser("openbootcamp");

        UsuariosNivel usuariosLvl = new UsuariosNivel(usuariosService);
        System.out.println("=============================================");

        usuariosLvl.isAdmin(usuariosService.getUser("Valwolfor"));
        usuariosLvl.isStudent(usuariosService.getUser("openbootcamp2"));
        usuariosLvl.isGuest(usuariosService.getUser("openbootcamp3"));

        mostrarEstadisticas(usuariosService.getUsuariosBD());
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
}

