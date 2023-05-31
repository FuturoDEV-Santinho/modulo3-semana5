package com.example.testesaula2.service;

import com.example.testesaula2.controller.ProdutoController;
import com.example.testesaula2.controller.dto.ProdutoDto;
import com.example.testesaula2.model.Produto;
import com.example.testesaula2.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service //indica um componente que contém uma lógica
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvaProduto(ProdutoDto produtoDto) {
        Produto produtoSalvo = repository.save(new Produto(
                produtoDto.getNomeProduto(),
                produtoDto.getValorProduto(),
                LocalDate.now().plusYears(5)
        ));
        return produtoSalvo;
    }

    public List<Produto> retornaTodosProdutos() {
        return repository.findAll();
    }
}
