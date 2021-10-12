package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financiamento;
import entities.factory.FinanciamentoFactory;

public class FinanciamentoTests {

	@Test
	public void finaciamentoDeveSerAceitoQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertEquals(10000.0, f.getValorTotal());
		Assertions.assertEquals(2000.0, f.getRendaMensal());
		Assertions.assertEquals(10, f.getMeses());
	}
	
	@Test
	public void finaciamentoDeveLancarUmaExcecaoQuandoOsDadosForemInvalidos() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financiamento f = FinanciamentoFactory.criarFinanciamentoInvalido();
		});
	}
	
	@Test
	public void DeveAtualizarOValorTotalQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		f.setValorTotal(8000.0);
		
		Assertions.assertEquals(8000.0, f.getValorTotal());
	
	}
	
	@Test
	public void DeveLancarUmaExcecaoQuandoTentarAtualizarOValorTotalComDadosInvalidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setValorTotal(30000.0);
		});
	}
	
	@Test
	public void DeveAtualizarARendaMensalQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		f.setRendaMensal(8000.0);
		
		Assertions.assertEquals(8000.0, f.getRendaMensal());
	
	}
	
	@Test
	public void DeveLancarUmaExcecaoQuandoTentarAtualizarRendaMensalComDadosInvalidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setRendaMensal(1000.0);
		});
	}
	
	@Test
	public void DeveAtualizarOsMesesQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		f.setMeses(20);
		
		Assertions.assertEquals(20, f.getMeses());
	
	}
	
	@Test
	public void DeveLancarUmaExcecaoQuandoTentarAtualizarOsMesesComDadosInvalidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			f.setMeses(2);
		});
	}
	
	@Test
	public void DeveCalcularCorrentamenteOValorDaEntradaQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertEquals(2000.0, f.entradaFinanciamento());
	}
	
	@Test
	public void DeveCalcularCorretamenteOValorDaPrestacaoQuandoOsDadosForemValidos() {
		
		Financiamento f = FinanciamentoFactory.criarFinanciamento();
		
		Assertions.assertEquals(800.0, f.prestacaoMensal());
	
	}

}
