package tests;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import entities.Conta;
import entities.factory.ContaFactory;

public class ContaTests {

	@Test
	public void depositoDeveAumentarSaldoQuandoValorForPositivo() {
		
		//Padrão AAA = Arange, Act e Assert
		
		//Arange
		double valor = 200.0;
		double valorEsperado = 196.0;
		Conta c = ContaFactory.criarContaComSaldoZero();
		
		//Act
		c.Deposito(valor);
		
		//Assert
		Assertions.assertEquals(valorEsperado, c.getSaldo());
	}
	
	@Test
	public void depositoDeveFazerNadaQuandoValorForNegativo() {
		
		//Padrão AAA = Arange, Act e Assert
		
		//Arange
		double valor = -200.0;
		double valorEsperado = 100.0;
		Conta c = ContaFactory.criarConta(valorEsperado);
		
		//Act
		c.Deposito(valor);
		
		//Assert
		Assertions.assertEquals(valorEsperado, c.getSaldo());
	}
	
	@Test
	public void saqueCompletoDeveZerarSaldoERetornarValorSacado() {
		
		//Padrão AAA = Arange, Act e Assert
		
		//Arange
		double valorEsperado = 0.0;
		double valorInicial = 800.0;
		Conta c = ContaFactory.criarConta(valorInicial);
		
		//Act
		double r = c.saqueCompleto();
		
		//Assert
		Assertions.assertTrue(valorEsperado == c.getSaldo());
		Assertions.assertTrue(r == valorInicial);
	}
	
	@Test
	public void saqueDeveDecrementaroSaldoQuandoOsaldoForSuficiente() {
		
		//Padrão AAA = Arange, Act e Assert
		
		//Arange
		double valor = 300.0;
		double valorInicial = 500.0;
		Conta c = ContaFactory.criarConta(valorInicial);
		
		//Act
		c.Saque(valor);
		
		//Assert
		Assertions.assertEquals(200.0, c.getSaldo());
	}
	
	@Test
	public void saqueDeveLancarUmaExcecaoQuandoOSaldoForInsuficiente() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			double valor = 300.0;
			double valorInicial = 200.0;
			Conta c = ContaFactory.criarConta(valorInicial);

			c.Saque(valor);
		});
	}
	
}
