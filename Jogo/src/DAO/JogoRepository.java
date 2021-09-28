package DAO;

import java.util.ArrayList;
import java.util.List;

import model.Jogo;

public class JogoRepository {
	private static JogoRepository jogoRepository;
	private List<Jogo> jogos = new ArrayList<>();
	private int lastId = 0;
	
	private JogoRepository() {
		
	}
	public static JogoRepository getInstance() {
        if (jogoRepository == null) {
        	jogoRepository = new JogoRepository();
        }
        return jogoRepository;
    }
	
	public List<Jogo> getJogos(){
		return this.jogos;
	}
	
	public Jogo findJogo(int id) {
		if(id<0) {
			return null;
		}
		for(Jogo jogo: jogos) {
			if(jogo.getId() == id) {
				return jogo;
			}
		}
		return null;
	}
	
	public boolean findByEmailNome(String nomeJogo, String email) {
		for(Jogo jogo: jogos) {
			if(jogo.getEmail().equals(email) && jogo.getNomeJogo().equals(nomeJogo)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean addJogo(String nome, Double preco, String dia, String mes, String ano, String email) {
		if(findByEmailNome(nome, email)) {
			return false;
		}
		Jogo newJogo = new Jogo();
		boolean boolId = newJogo.setId(lastId);
		boolean boolNome = newJogo.setNomeJogo(nome);
		boolean boolPreco = newJogo.setPrecoJogo(preco);
		boolean boolData = newJogo.setDataCompra(dia, mes, ano);
		boolean boolEmail = newJogo.setEmail(email);
		if( boolId && boolNome && boolPreco && boolData && boolEmail) {
			this.lastId += 1;
			return jogos.add(newJogo);
		}
		return false;
		
	}
	
	public boolean removerJogo(int id) {
		Jogo jogoAntigo = findJogo(id);
		if(jogoAntigo != null) {
			jogos.remove(jogoAntigo);
			return true;
		}
		return false;
	}
	
	public boolean atualizarJogo(String nome, Double preco,  String dia, String mes, String ano, String email, int id) {
		Jogo jogoAntigo = findJogo(id);
		
		if(jogoAntigo == null) {
			return false;
		}
		if(findByEmailNome(nome, email)) {
			return false;
		}
		Jogo newJogo = new Jogo();
		boolean boolId = newJogo.setId(jogoAntigo.getId());
		boolean boolNome = newJogo.setNomeJogo(nome);
		boolean boolPreco = newJogo.setPrecoJogo(preco);
		boolean boolData = newJogo.setDataCompra(dia, mes, ano);
		boolean boolEmail = newJogo.setEmail(email);
		if( !(boolId && boolNome && boolPreco && boolData && boolEmail)) {
			return false;
		}
		jogoAntigo.setNomeJogo(nome);
		jogoAntigo.setPrecoJogo(preco);
		jogoAntigo.setDataCompra(dia, mes, ano);
		jogoAntigo.setEmail(email);
		return true;
	}

}
