package br.ufc.controller;


import java.util.List;

import br.ufc.DAO.JogoRepository;
import br.ufc.model.Jogo;

public class JogoController {
	private JogoRepository jogoRepository = JogoRepository.getInstance();
	
	public boolean cadastrarJogo(String nome, Double preco, String dia, String mes, String ano, String email) {
		return jogoRepository.addJogo(nome, preco, dia, mes, ano, email);
	}
	
	public boolean removerJogo(int id) {
		return jogoRepository.removerJogo(id);
	}
	
	public boolean editarJogo(String nome, Double preco, String dia, String mes, String ano, String email, int id) {
		return jogoRepository.atualizarJogo(nome, preco, dia, mes, ano, email, id);
	}
	
	public List<Jogo> getJogos(){
		return jogoRepository.getJogos();
	}
	
	public Jogo getJogoById(int id) {
		return jogoRepository.findJogo(id);
	}
}
