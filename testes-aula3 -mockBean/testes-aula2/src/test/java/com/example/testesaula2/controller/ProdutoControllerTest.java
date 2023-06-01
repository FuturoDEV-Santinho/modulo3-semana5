package com.example.testesaula2.controller;

import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest // carrega o contexto do spring dentro do teste, Controller, Service, Respository
@AutoConfigureMockMvc // configura o MockMvc de forma automática
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class ProdutoControllerTest {

    @MockBean //gera uma respsta pré-definida para um bean
    //@Service, @Repository, @RestControlle, @Component
    ProdutoRepository repository;

    @Autowired
    MockMvc mockMvc; // realiza chamadas aos endpoints como se fosse um agente externo(insomnia)

    @Test
    void encontraTodosProdutos() throws Exception {
        List<Produto> produtoMockList = List.of(
                new Produto(1L, "Papel", 1.1, LocalDate.now()));

        when(repository.findAll()).thenReturn(produtoMockList);

        mockMvc.perform( //execução da chamada de um endpoint
                MockMvcRequestBuilders
                        .get("/produto") //indica que vamos chamar o endpoint /produto com o Método Get
                        .accept(MediaType.APPLICATION_JSON) //espero um JSON como resposta desse endpoint
        ).andExpect(
                MockMvcResultMatchers //indica a resposta esperada da chamada do endpoint /produto
                        .status().isOk() // valida se o resultado da chamada teve status 200 OK
        ).andExpect(MockMvcResultMatchers.content().json(
                """
                        [
                            {
                         		"id": 1,
                         		"nomeProduto": "Papel",
                         		"valorProduto": 1.1,
                         		"dataValidade": "2023-05-31"
                         	}
                        ]
                        """
        ))
        ;
    }

    @Test
    void salvaProduto() throws Exception {
        Produto produtoMock =
                new Produto(1L, "Papel", 1.1, LocalDate.now());

        when(repository.save(any())).thenReturn(produtoMock);

        mockMvc.perform( //execução da chamada de um endpoint
                MockMvcRequestBuilders
                        .post("/produto") //indica que vamos chamar o endpoint /produto com o Método POST
                        .accept(MediaType.APPLICATION_JSON) //espero um JSON como resposta desse endpoint
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                {
                                	"nomeProduto": "Papel A4",
                                	"valorProduto": 10.0
                                }
                                """
                        )
        ).andExpect(
                MockMvcResultMatchers //indica a resposta esperada da chamada do endpoint /produto
                        .status().isCreated() // valida se o resultado da chamada teve status 201 Created
        ).andExpect(MockMvcResultMatchers.content().json(
                """
                        {
                          	"id": 1,
                          	"nomeProduto": "Papel",
                          	"valorProduto": 1.1,
                          	"dataValidade": "2023-05-31"
                          }
                        """
        ))
        ;
    }
}