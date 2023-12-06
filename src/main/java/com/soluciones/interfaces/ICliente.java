package com.soluciones.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soluciones.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, Integer> {

}
