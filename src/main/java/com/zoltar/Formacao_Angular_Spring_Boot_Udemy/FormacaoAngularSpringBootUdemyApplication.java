package com.zoltar.Formacao_Angular_Spring_Boot_Udemy;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Chamado;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Cliente;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.Tecnico;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.enums.Perfil;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.enums.Prioridade;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.domain.enums.Status;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.ChamadoRepository;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.ClienteRepository;
import com.zoltar.Formacao_Angular_Spring_Boot_Udemy.repositories.TecnicoRepository;

@SpringBootApplication
public class FormacaoAngularSpringBootUdemyApplication implements CommandLineRunner{
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	public static void main(String[] args) {
		SpringApplication.run(FormacaoAngularSpringBootUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Tecnico tec = new Tecnico(null, "Valdir Cezar", "64653230268", "valdir@mail.com", "123");
		tec.addPerfil(Perfil.ADMIN);
		
		Cliente cli = new Cliente(null, "Linus Torvalds", "80527954780", "torvalds@mail.com", "123");
		
		Chamado cha = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec, cli);

		tecnicoRepository.saveAll(Arrays.asList(tec));
		clienteRepository.saveAll(Arrays.asList(cli));
		chamadoRepository.saveAll(Arrays.asList(cha));
	}

}
