package com.example.testesaula2.repository;

import com.example.testesaula2.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                                       //    tabela    id da tabela
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
