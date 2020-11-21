package com.github.alexsep.resource;

import com.github.alexsep.model.Ordem;
import com.github.alexsep.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/ordens")
public class OrdemResource {

    private OrdemService ordemService;

    @Inject
    public OrdemResource(OrdemService ordemService){
        this.ordemService = ordemService;
    }

    @POST
    @Transactional
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(@Context SecurityContext securityContext, Ordem ordem) {
        this.ordemService.create(securityContext, ordem);
    }


}
