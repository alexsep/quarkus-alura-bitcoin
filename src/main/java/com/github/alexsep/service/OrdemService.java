package com.github.alexsep.service;

import com.github.alexsep.model.Ordem;
import com.github.alexsep.model.Usuario;
import com.github.alexsep.repositoy.OrdemRepository;
import com.github.alexsep.repositoy.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    private OrdemRepository ordemRepository;

    private UsuarioRepository usuarioRepository;

    @Inject
    public OrdemService(OrdemRepository ordemRepository, UsuarioRepository usuarioRepository){
        this.ordemRepository = ordemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public void create(SecurityContext securityContext, Ordem ordem) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findByIdOptional(ordem.getUserId());
        Usuario usuario = usuarioOptional.orElseThrow();

        if(!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())){
            throw  new RuntimeException("O usuário logado é diferente do userId");
        }


        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }
}
