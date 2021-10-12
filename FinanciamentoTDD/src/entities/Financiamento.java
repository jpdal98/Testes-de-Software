package entities;

public class Financiamento {

	private Double valorTotal;
	private Double rendaMensal;
	private Integer meses;
	
	public Financiamento() {
		
	}

	public Financiamento(Double valorTotal, Double rendaMensal, Integer meses) {
		validacaoFinanciamento(valorTotal, rendaMensal, meses);
		this.valorTotal = valorTotal;
		this.rendaMensal = rendaMensal;
		this.meses = meses;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		validacaoFinanciamento(valorTotal, rendaMensal, meses);
		this.valorTotal = valorTotal;
	}

	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		validacaoFinanciamento(valorTotal, rendaMensal, meses);
		this.rendaMensal = rendaMensal;
	}

	public Integer getMeses() {
		return meses;
	}

	public void setMeses(Integer meses) {
		validacaoFinanciamento(valorTotal, rendaMensal, meses);
		this.meses = meses;
	}
	
	public double entradaFinanciamento() {
		return valorTotal * 0.2;
	}
	
	public double prestacaoMensal() {
		return (valorTotal - entradaFinanciamento()) / meses;
	}
	
	public void validacaoFinanciamento(Double valorTotal, Double rendaMensal, Integer meses) {
		if(valorTotal * 0.8 / meses > rendaMensal / 2.0) {
			throw new IllegalArgumentException("A parcela não pode ser maior que a metade da renda");
		}
	}
}
