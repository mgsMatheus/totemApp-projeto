package br.com.fiap.saude;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SaudeApplication {

	public static void main(String[] args) {SpringApplication.run(SaudeApplication.class, args); }

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}
}

