package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTeste {

    @Test // indica que um método é um método de teste
    // o método somaTeste realiza o teste do método soma de Calculadora
    // é o teste unitário do método soma
    void somaTeste() {
        // criar um objeto calculadora
        Calculadora calculadora = new Calculadora();

        // realiza a chamada do soma com valores pré definidos
        double resultado = calculadora.soma(1.0,2.2);

        // valida o resultado da soma
        // o assertEquals valida se o valor do 1º parametro é igual ao valor do 2º
        assertEquals(13.2,resultado);
        assertNotEquals(0,resultado);
    }

    // multiplicação, divisão, subtração e façam a formula de bhaskara

    @Test
    void bhaskaraTeste(){
        Calculadora calculadora = new Calculadora();

        double resultado = calculadora.bhaskara(1.0,8.0,-9.0);

        assertNotEquals(Double.MAX_VALUE,resultado);
        assertEquals(-3.0,resultado);

    }
}