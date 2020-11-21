package com.github.alexsep.resource;

import com.github.alexsep.model.Usuario;
import com.github.alexsep.repositoy.UsuarioRepository;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioResource(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @POST
    @PermitAll
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Usuario usuario) {

        Usuario.adicionar(usuario);

        usuarioRepository.persist(usuario);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> findAll(){
        return usuarioRepository.listAll();
    }


}
