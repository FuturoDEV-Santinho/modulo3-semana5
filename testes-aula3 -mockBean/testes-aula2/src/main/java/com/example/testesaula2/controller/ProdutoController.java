package com.example.testesaula2.controller;

import com.example.testesaula2.controller.dto.ProdutoDto;
import com.example.testesaula2.model.Produto;
import com.example.testesaula2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    // injeção por construtor
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> encontraTodosProdutos(){
        List<Produto> resposta = produtoService.retornaTodosProdutos();

        return ResponseEntity.ok(resposta);
    }

    @PostMapping
    public ResponseEntity<Produto> salvaProduto(
            @RequestBody ProdutoDto produtoDto
    ){
        Produto resposta = produtoService.salvaProduto(produtoDto);

        return new ResponseEntity<Produto>(resposta, HttpStatus.CREATED);
    }
}
