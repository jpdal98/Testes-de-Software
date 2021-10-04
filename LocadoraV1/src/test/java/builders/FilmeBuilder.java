package builders;

import br.ufc.entities.Filme;

public class FilmeBuilder {

	private Filme filme;
	
	private void FilmeBuilder() {
		
	}
	
	public static FilmeBuilder umFilme() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("Jogos mortais");
		builder.filme.setEstoque(2);
		builder.filme.setPrecoLocacao(4.50);
		return builder;
	}
	
	public static FilmeBuilder umFilmeSemEstoque() {
		FilmeBuilder builder = new FilmeBuilder();
		builder.filme = new Filme();
		builder.filme.setNome("Jogos mortais");
		builder.filme.setEstoque(0);
		builder.filme.setPrecoLocacao(4.50);
		return builder;
	}
	
	public FilmeBuilder filmeSemEstoque() {
		filme.setEstoque(0);
		return this;
	}
			
	public Filme agora() {
		return filme;
	}
}
