package cleaning;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosDB {
    private final String ficheroDatos = "usuarios.txt";
    private ArrayList<Usuario> usuariosArray;

    /**
     * Convierte a array de String los valores obtenidos del archivo.
     *
     * @return Array de String con la lista de usuarios ingresados.
     */
    public ArrayList<Usuario> parseToArrayUsuario() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String[] partes = usuarioActual.split(",");

                usuarios.add(buildUsuario(partes));
            }

            scanner.close();
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            exceptionHandler(e);
        }

        return usuarios;
    }

    /**
     * En el archivo base agrega una linea con los datos del nuevo usuario.
     *
     * @param buffer String con parametros separados por separador.
     */
    public void writeInFlie(String buffer) {
        FileOutputStream fileOS;
        PrintStream printStream;

        try {
            fileOS = new FileOutputStream(ficheroDatos, true);
            printStream = new PrintStream(fileOS);
            printStream.println(buffer);

            printStream.flush();
            printStream.close();
            FileOutputStream.nullOutputStream().close();
        } catch (IOException e) {
            exceptionHandler(e);
        }
    }

    /**
     * En el archivo  sobre-escribe los datos pasados por el parametro, luego de ser eliminado el
     * objetos solicitado.
     *
     * @param buffer String con parametros separados por separador.
     */
    public void reWriteInFlie(String buffer) {
        PrintStream printStream;

        try {
            printStream = new PrintStream(ficheroDatos);
            printStream.println(buffer);

            printStream.flush();
            printStream.close();
        } catch (FileNotFoundException e) {
            exceptionHandler(e);
        }
    }

    /**
     * Agrega un usuario a la bd de datos, sobre escribiendo el archivo y verificando la
     * existencia del mismo.
     *
     * @param newUsuario Nuevo Usuario a agregar.
     */
    public void addUser(Usuario newUsuario) {
        StringBuilder buffer = new StringBuilder();

        if (verificarUsuario(newUsuario.getNombreUsuario()) != null) {
            System.out.println("Usuario: " + newUsuario.getNombreUsuario() + " ya existe.");
            return;
        }

        buffer.append(parseBufferUsuario(newUsuario));
        writeInFlie(buffer.toString());
    }

    /**
     * Recibe el archivo y verifia la existencia del mismo, eliminandolo y reescribiendo el
     * fichero con el registro actualizado.
     *
     * @param username Nombre de usuario de objeto Usuario a eliminar.
     */
    public void deleteUsuario(String username) {
        StringBuilder buffer = new StringBuilder();
        usuariosArray = parseToArrayUsuario();

        for (Usuario usuarioActual : usuariosArray) {
            if (!usuarioActual.getNombreUsuario().equalsIgnoreCase(username)) {
                buffer.append(parseBufferUsuario(usuarioActual)).append("\n");
            }
        }

    reWriteInFlie(buffer.toString());
}

    /**
     * Verifica la existencia de un usuario por el nombre de usuario.
     *
     * @param sNombreUsuario String de nombre de usuario a verificar.
     * @return boolean.
     */
    public Usuario verificarUsuario(String sNombreUsuario) {
        usuariosArray = parseToArrayUsuario();
        for (Usuario usuario : usuariosArray) {
            String nombreActual = usuario.getNombreUsuario();

            if (nombreActual.equalsIgnoreCase(sNombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Construye un usuario de un array de string.
     *
     * @param args Array de string con los valores de cada uno de los atributos
     * @return objeto construido de Usuario
     */
    private Usuario buildUsuario(String[] args) {
        UsuarioBuilder builderUser = new UsuarioBuilder(args[0])
                .setNombre(args[1])
                .setApellidos(args[2])
                .setEmail(args[3])
                .setNivelDeAcceso(Integer.parseInt(args[4]));

        return builderUser.getUsuario();
    }

    /**
     * Convierte a String el objeto ingresado.
     *
     * @param usuario objeto que se desea pasar a string, separando propiedades por Separador.
     * @return String con propiedades de objeto.
     */
    private String parseBufferUsuario(Usuario usuario) {
        String buffer = "";

        char separador = ',';
        buffer += usuario.getNombreUsuario() + separador
                + usuario.getNombre() + separador
                + usuario.getApellidos() + separador
                + usuario.getEmail() + separador
                + usuario.getNivelAcceso() + separador;

        return buffer;
    }

    /**
     * Retorna el mensaje de error, la clase y la traza de error.
     *
     * @param e Excepción que se lanza.
     */
    private void exceptionHandler(Exception e) {
        System.out.println("Hubo un error:" + e.getMessage() + " " + e.getClass());
        for (StackTraceElement element : e.getStackTrace()) {
            System.out.println(element);
        }
    }
}
