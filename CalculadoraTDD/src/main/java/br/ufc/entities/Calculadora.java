package br.ufc.entities;

import br.ufc.exceptions.NaoPodeDividirPorZeroExcetion;

public class Calculadora {

	public int somar(int a, int b) {
		return a + b;
	}

	public int subtrair(int a, int b) {
		return a - b;
	}

	public int dividir(int a, int b) throws NaoPodeDividirPorZeroExcetion {
		if(b == 0) {
			throw new NaoPodeDividirPorZeroExcetion("Um numero dividido por zero é igual a zero");
		}
		
		return a / b;
	}

	
}
