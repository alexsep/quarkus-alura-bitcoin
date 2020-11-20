package com.github.alexsep.repositoy;

import com.github.alexsep.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
}
