package com.javamos.projeto.repo;

import org.springframework.data.repository.CrudRepository;

import com.javamos.projeto.model.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {

}
