package com.example.testesaula2.controller.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//          ProdutoRequest
public class ProdutoDto {
    private String nomeProduto;
    private Double valorProduto;
}
