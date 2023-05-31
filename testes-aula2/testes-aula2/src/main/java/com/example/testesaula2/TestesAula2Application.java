package com.example.testesaula2;

import com.example.testesaula2.controller.ProdutoController;
import com.example.testesaula2.service.ProdutoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestesAula2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestesAula2Application.class, args);

//		// memoria Spring
//		ProdutoService service = new ProdutoService();
//		ProdutoController produtoController = new ProdutoController(service);
//		// memoria Spring
	}

}
