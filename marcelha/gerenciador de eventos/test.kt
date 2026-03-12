package Dede Eventos

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculadoraTest {

    @Test
    fun `deve somar dois numeros corretamente`() {
        // GIVEN (Dado que...)
        val calculadora = Calculadora()
        
        // WHEN (Quando...)
        val resultado = calculadora.somar(10, 5)
        
        // THEN (Então...)
        assertEquals(15, resultado, "A soma de 10 + 5 deve ser 15")
    }

    @Test
    fun `deve retornar verdadeiro quando o numero for par`() {
        val calculadora = Calculadora()
        val ehPar = calculadora.verificarSeEhPar(4)
        
        assertEquals(true, ehPar)
    }
}
