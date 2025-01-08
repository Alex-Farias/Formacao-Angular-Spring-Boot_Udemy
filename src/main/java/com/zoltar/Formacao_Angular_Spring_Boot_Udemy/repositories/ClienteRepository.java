package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
