package com.github.alexsep.resource;

import com.github.alexsep.model.Ordem;
import com.github.alexsep.repositoy.OrdemRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/ordens")
public class OrdemResource {

    @Inject
    OrdemRepository ordemRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Ordem ordem) {
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");

        ordemRepository.persist(ordem);
    }


}
