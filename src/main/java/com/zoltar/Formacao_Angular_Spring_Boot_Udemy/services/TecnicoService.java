package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Tecnico;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
