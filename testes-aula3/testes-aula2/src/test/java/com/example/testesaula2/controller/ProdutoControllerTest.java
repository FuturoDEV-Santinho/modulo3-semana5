package com.example.testesaula2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // carrega o contexto do spring dentro do teste, Controller, Service, Respository
@AutoConfigureMockMvc // configura o MockMvc de forma automática
class ProdutoControllerTest {

    @Autowired
    MockMvc mockMvc; // realiza chamadas aos endpoints como se fosse um agente externo(insomnia)

    @Test
    void encontraTodosProdutos() throws Exception {
        mockMvc.perform( //execução da chamada de um endpoint
                MockMvcRequestBuilders
                        .get("/produto") //indica que vamos chamar o endpoint /produto com o Método Get
                        .accept(MediaType.APPLICATION_JSON) //espero um JSON como resposta desse endpoint
        ).andExpect(
                MockMvcResultMatchers //indica a resposta esperada da chamada do endpoint /produto
                        .status().isOk() // valida se o resultado da chamada teve status 200 OK
        ).andExpect(MockMvcResultMatchers.content().json(
                """
                        []
                        """
        ))
        ;
    }

    @Test
    void salvaProduto() throws Exception {

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
                          	"nomeProduto": "Papel A4",
                          	"valorProduto": 10.0,
                          	"dataValidade": "2028-05-31"
                          }
                        """
        ))
        ;
    }
}