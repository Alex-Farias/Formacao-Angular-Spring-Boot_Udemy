package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
