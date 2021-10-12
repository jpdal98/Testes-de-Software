package entities.factory;

import entities.Financiamento;

public class FinanciamentoFactory {

	public static Financiamento criarFinanciamento() {
		return new Financiamento(10000.0, 2000.0, 10);
	}
	
	public static Financiamento criarFinanciamentoInvalido() {
		return new Financiamento(100000.0, 2000.0, 20);
	}
}
