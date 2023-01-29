package br.com.cro.emprestimos_teste;

import br.com.cro.emprestimos_teste.model.Cliente;
import br.com.cro.emprestimos_teste.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmprestimosTesteApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();

	}

	public static void main(String[] args) {
		SpringApplication.run(EmprestimosTesteApplication.class, args);
	}



	}


