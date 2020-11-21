package com.github.alexsep.resource;

import com.github.alexsep.model.Usuario;
import com.github.alexsep.repositoy.UsuarioRepository;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioRepository usuarioRepository;


    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Usuario usuario) {

        Usuario.adicionar(usuario);

        usuarioRepository.persist(usuario);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Usuario> findAll(){
//        return Usuario.findAll();
//    }


}
