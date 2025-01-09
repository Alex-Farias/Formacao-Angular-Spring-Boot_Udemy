package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Chamado;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.dtos.ChamadoDTO;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services.ChamadoService;

@RestController
@RequestMapping(value = "/chamados")
public class ChamadoResource {
	@Autowired
	private ChamadoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id){
		Chamado obj = service.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ChamadoDTO>> findAll(){
		List<Chamado> list = service.findAll();
		List<ChamadoDTO> listDTO = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
