package br.ufc.tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ufc.entities.Calculadora;
import br.ufc.exceptions.NaoPodeDividirPorZeroExcetion;

// ciclo do desenvolvimento TDD - Teste, codigo e refatoração
public class CalculadoraTeste {

	@Test
	public void deveSomarDoisValores() {
		//cenario
		int a = 5;
		int b = 3;
		Calculadora calculadora = new Calculadora();
		
		//acao
		int c = calculadora.somar(a, b);
		
		//verificação
		Assert.assertEquals(8, c);
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		//cenario
		int a = 8;
		int b = 5;
		Calculadora calculadora = new Calculadora();
		
		//acao
		int c = calculadora.subtrair(a, b);
		
		//verificação
		Assert.assertEquals(3, c);
	}
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroExcetion {
		//cenario
		int a = 6;
		int b = 3;
		Calculadora calculadora = new Calculadora();
		
		//acao
		int c = calculadora.dividir(a, b);
		
		//verificação
		Assert.assertEquals(2, c);
	}
	
	@Test
	public void deveLancarExcecaoAoDividirPorZero() {
		//cenario
		int a = 6;
		int b = 0;
		Calculadora calculadora = new Calculadora();
		
		try {
			//acao
			calculadora.dividir(a, b);
			Assert.fail();
		} catch (NaoPodeDividirPorZeroExcetion e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is("Um numero dividido por zero é igual a zero"));
		}
	}
	
	//vantagens do TDD:
	//qualidade do codigo - o codigo se torna consizo, com menor acoplamento, mais aberto e
	//mais simples.
	
	
	//desvantagens do TDD:
	//curva de aprendizado - não é tão trivial quebrar um funcionalidade em pequenos 
	//incrementos, isso requer prática 
	//TDD não acelera o seu desenvolvimento - voce acaba investindo maior parte do tempo
	//na implementação dos testes. O retorno só virá em fases mais avançadas do projeto
}
