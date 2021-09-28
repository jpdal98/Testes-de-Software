package br.ufc.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Jogo {
	private Integer id;
	private String nomeJogo;
	private Double precoJogo;
	private Date dataCompra;
	private String email;
	
	public Jogo() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean setId(int id) {
		if(id < 0) {
			return false;
		}
		this.id = id;
		return true;
	}
	
	
	public String getNomeJogo() {
		return nomeJogo;
	}
	public boolean setNomeJogo(String nomeJogo) {
		if(nomeJogo != null && nomeJogo != "" && nomeJogo.matches("[[A-Z][a-z][0-9]]+[[[A-Z][a-z][0-9]]*\\s*]*[[A-Z][a-z][0-9]]+")){
			this.nomeJogo = nomeJogo;
			return true;
		}
		return false;
	}
	
	public Double getPrecoJogo() {
		return this.precoJogo;
	}
	public boolean setPrecoJogo(Double precoJogo) {
		if(precoJogo == null ||precoJogo < 0 ) {
			return false;
		}
		this.precoJogo = precoJogo;
		return true;
	}
	
	public Date getDataCompra() {
		return this.dataCompra;
	}
	public boolean setDataCompra(String dia, String mes, String ano) {
		int diaInt = 0;
		int mesInt = 0;
		int anoInt = 0;		
		try {
			diaInt = Integer.parseInt(dia);
			mesInt = Integer.parseInt(mes);
			anoInt = Integer.parseInt(ano);			
		}catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		if(diaInt < 1 || mesInt < 1 || anoInt < 1990 || diaInt > 31 || mesInt > 12 || anoInt > anoAtual) {
			return false;
		}
		SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
		try {
			String novaData = Integer.toString(diaInt) + "/" + Integer.toString(mesInt) + "/" + Integer.toString(anoInt);
			this.dataCompra = formatar.parse(novaData);
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
		return true;
	}
	
	public String getEmail() {
		return this.email;
	}
	public boolean setEmail(String email) {
		if(email == null || email == "" || !email.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+")) {
			return false;
		}
		this.email = email;
		return true;
	}
	
	@Override
	public String toString() {
		return "Jogo [id=" + id + ", nomeJogo=" +
				nomeJogo + ", precoJogo=" + precoJogo +
				", dataCompra=" + dataCompra
				+ ", email=" + email + "]";
	}
	
}
