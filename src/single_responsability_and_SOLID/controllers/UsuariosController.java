package single_responsability_and_SOLID.controllers;


import single_responsability_and_SOLID.entities.Usuario;
import single_responsability_and_SOLID.services.UsuariosService;

import java.util.ArrayList;

//@Componet
//@Path("/")
public class UsuariosController {
    private /*final*/ UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService){
        this.usuariosService = usuariosService;
    }

    private UsuariosController(){

    }

//    @GET
//    @Path("/usuarios")
    public ArrayList<Usuario> getAll(){
        return usuariosService.getAll();
    }

//    @GET
//    @Path("/usuarios/{userName}")
    public Usuario getUsuario(/*@PathParam(userName)*/String userName){
        return usuariosService.getUser(userName);
    }

//    @POST
//    @Path("/usuarios")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public /*Response*/void addUsuario(Usuario usuario){
        usuariosService.addUser(usuario);

//        return Response.created(URI.create("/usuarios" + usuario.getNombreUsuario())
//        ).build();
    }

//    @DELETE
//    @Path("/usuarios/{userName}")
//    @Consumes(MediaType.APPLICATION_JSON)
    public /*Response*/void deleteUsuario(Usuario usuario){
        usuariosService.deleteUser(usuario.getNombreUsuario());

//        return Response.ok().build();
    }

}
