package com.zoltar.Formacao_Angular_Spring_Boot_Udemy.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Pessoa;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.PessoaRepository;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	private PessoaRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> user = repository.findByEmail(email);
		if(user.isPresent()) {
			return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getSenha(), user.get().getPerfis());
		}
		throw new UsernameNotFoundException(email);
	}

}
