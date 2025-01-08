package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
