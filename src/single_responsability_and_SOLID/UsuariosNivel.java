package single_responsability_and_SOLID;

/**
 * Herada de la Clase de gestion de Usuarios y extiende métodos de verificación de nivel de acceso.
 */
public class UsuariosNivel extends Usuarios {
    public UsuariosNivel(UsuariosDB usuariosBD) {
        super(usuariosBD);
    }

    public boolean isAdmin(Usuario user) {
        int level = 10;
        String lvlName = "administrador";
        return senderAnswer(checkLevelAccess(user, level), lvlName);
    }

    public boolean isStudent(Usuario user) {
        int level = 5;
        String lvlName = "estudiante";
        return senderAnswer(checkLevelAccess(user, level), lvlName);
    }

    public boolean isGuest(Usuario user) {
        int level = 1;
        String lvlName = "invitado";
        return senderAnswer(checkLevelAccess(user, level), lvlName);
    }

    /**
     * Obtenido el resultado del chequeo, gestiona mensaje según resultado.
     *
     * @param check   boolean de resultado sobre nivel de acceso.
     * @param lvlName String del nombre de nivel.
     * @return booleano sobre nivel de usuario.
     */
    private boolean senderAnswer(boolean check, String lvlName) {
        if (!check) {
            System.out.println("No tiene los permisos suficientes para " + lvlName);
            return false;
        }
        System.out.println("Tiene un nivel de acceso de " + lvlName);
        return true;
    }

    /**
     * Verifica la existencia del usuario lo recibe desde la BD para garantizar integridad y
     * verifica el nivel de acceso.
     *
     * @param user    Objeto tipo usuario que se desea verificar.
     * @param lvlTest int que contendrá el nivel a evaluar.
     * @return Boolean que indica el nivel de acceso.
     */
    private boolean checkLevelAccess(Usuario user, int lvlTest) {
        Usuario usuarioGetted = super.getUser(user.getNombreUsuario());
        System.out.println("El usuario: " + user.getNombreUsuario());

        if (usuarioGetted != null) {
            return user.getNivelAcceso() >= lvlTest;
        }

        return false;
    }
}
