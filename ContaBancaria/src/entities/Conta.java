package entities;

public class Conta {

	public static double taxaPorcentagemDeposito = 0.02;
	
	private Long id;
	private Double saldo;
	
	public Conta () {
		
	}

	public Conta(Long id, Double saldo) {
		this.id = id;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public void Deposito(Double valor) {
		if(valor <= 0) {
			System.out.println("valor de deposito invalido!!");
			return;
		}
		valor -= valor * taxaPorcentagemDeposito;
		this.saldo += valor;
	}
	
	public void Saque(Double valor) {
		if(valor > saldo) {
			throw new IllegalArgumentException();
		}
		if(valor <= 0) {
			System.out.println("valor de saque invalido!!");
			return;
		}
		this.saldo -= valor;
	}
	
	public Double saqueCompleto() {
		double aux = saldo;
		saldo = 0.0;
		return aux;
	}
}
