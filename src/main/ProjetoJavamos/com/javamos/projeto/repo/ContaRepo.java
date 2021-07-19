package com.javamos.projeto.repo;

import org.springframework.data.repository.CrudRepository;

import com.javamos.projeto.model.Conta;

public interface ContaRepo extends CrudRepository <Conta, Integer> {

}
