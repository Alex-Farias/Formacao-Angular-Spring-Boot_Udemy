package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Cliente;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Pessoa;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.dtos.ClienteDTO;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.ClienteRepository;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.PessoaRepository;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services.exceptions.DataIntegrityViolationException;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services.exceptions.ObjectnotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID:" + id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		
		if(!objDTO.getSenha().equals(oldObj.getSenha())){
			objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		}
		
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Cliente obj = findById(id);
		System.out.println("ID É IGUAL A:" + obj.getId());
		System.out.println("CHAMADOS QTD É IGUAL A:" + obj.getChamados().size());
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}
}
