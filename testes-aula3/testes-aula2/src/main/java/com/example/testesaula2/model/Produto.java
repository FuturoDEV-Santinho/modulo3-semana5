package com.example.testesaula2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "produto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private Double valorProduto;
    private LocalDate dataValidade;

    public Produto(String nomeProduto, Double valorProduto, LocalDate dataValidade) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.dataValidade = dataValidade;
    }
}
