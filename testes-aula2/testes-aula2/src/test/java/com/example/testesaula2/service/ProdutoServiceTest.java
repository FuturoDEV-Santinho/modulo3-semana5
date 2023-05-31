package com.example.testesaula2.service;

import com.example.testesaula2.controller.dto.ProdutoDto;
import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // adicionar as anotações
// e funcionalidades do mockito aos testes dessa classe
class ProdutoServiceTest {

    @Mock // indica um objeto mockado,
    // ou seja que irá ter as suas resposta falsificadas
    ProdutoRepository repository;

    @InjectMocks // indica o objeto que irá receber o Mock
    ProdutoService produtoService;

    @Test // indentifica que um método é um teste
    void salvaProduto() {
        // criando um Produto que não existe no banco de dados
        Produto produtoMock =
                new Produto(1L, "Papel", 1.1, LocalDate.now());

        // quando o repository.save for executado e receber qualquer objeto (any())
        // então ele irá retornar o produto mock
        when(repository.save(any())).thenReturn(produtoMock);

        Produto resultado = produtoService.salvaProduto(new ProdutoDto("Papel",1.0));

        assertNotNull(resultado);
        assertEquals(produtoMock.getNomeProduto(),resultado.getNomeProduto());
    }

    @Test
    void retornaTodosProdutos() {
    }
}