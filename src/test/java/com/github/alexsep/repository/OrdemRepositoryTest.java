package com.github.alexsep.repository;


import com.github.alexsep.model.Ordem;
import com.github.alexsep.repositoy.OrdemRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class OrdemRepositoryTest {

    @InjectMock
    private OrdemRepository ordemRepository;

    @Test
    public void shouldReturnOrdersList(){
        //Arrange
        Ordem firstOrder = new Ordem();
        Ordem secondOrder = new Ordem();
        List<Ordem> orders = new ArrayList<Ordem>();

        orders.add(firstOrder);
        orders.add(secondOrder);

        //Act
        Mockito.when(ordemRepository.listAll()).thenReturn(orders);

        //Assert
        Assertions.assertSame(secondOrder, ordemRepository.listAll().get(1));
    }


}
