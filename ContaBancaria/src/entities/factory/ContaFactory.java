package entities.factory;

import entities.Conta;

public class ContaFactory {

	public static Conta criarContaComSaldoZero() {
		return new Conta(1L, 0.0);
	}
	
	public static Conta criarConta(double valorInicial) {
		return new Conta(1L, valorInicial);
	}
}
