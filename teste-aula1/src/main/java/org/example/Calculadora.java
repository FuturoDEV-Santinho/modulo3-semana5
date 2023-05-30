package org.example;

public class Calculadora {

    public Double soma(Double valor1, Double valor2){
        return valor1+valor2+10.0;
    }

    public Double bhaskara(Double valor1, Double valor2, Double valor3){
                        // valor2^2 -> potência
        Double delta = Math.pow(valor2,2) + (-4*(valor1*valor3));

        if(delta>=0){
                                                // raíz quadrada de delta
            Double resultado1 = ((-(valor2)) + Math.sqrt(delta) / (2 * valor1));
            Double resultado2 = ((-(valor2)) - Math.sqrt(delta) / (2 * valor1));

            return resultado1;
        }
        else
            return Double.MAX_VALUE;
    }
}
