package br.ufc.tests;

import static org.junit.Assert.fail;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.ufc.entities.Filme;
import br.ufc.entities.Locacao;
import br.ufc.entities.Usuario;
import br.ufc.exceptions.FilmeSemEstoqueException;
import br.ufc.exceptions.LocadoraException;
import br.ufc.services.LocacaoService;
import br.ufc.utils.DataUtils;
import builders.FilmeBuilder;
import builders.UsuarioBuilder;

//executar os testes em ordem alfabetica
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTests {

	private LocacaoService service;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setup() {
		service = new LocacaoService();
	}
	
	@Test
	public void teste() throws Exception{
		
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = FilmeBuilder.umFilme().agora();
		
		//acao
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		//verificacao
		error.checkThat(locacao.getValor(), CoreMatchers.is(CoreMatchers.equalTo(4.50)));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}
	
	//falhas:ocorrem quando o teste é executado sem problemas, porém alguma condição que era
	//esperada não foi atendida.
	
	//erros:quando algum problema durante a execução do teste impede que o mesmo seja
	//concluido, ou seja, quando ocorre uma excessão não esperada e não tratada
	
	
	
	//Formas de testar se a exceção esta sendo lançada
	
	//Forma elegante
	@Test(expected = FilmeSemEstoqueException.class)
	public void testLocacao_filmeSemEstoque() throws Exception {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = FilmeBuilder.umFilme().filmeSemEstoque().agora();
		
		//acao
		service.alugarFilme(usuario, filme);
		
	}
	
	//Forma robusta
	@Test
	public void testLocacao_filmeSemEstoque2(){
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = FilmeBuilder.umFilme().filmeSemEstoque().agora();
		
		//acao
		try {
			service.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lançado uma exceção");
		} catch (Exception e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is(CoreMatchers.equalTo("Filme sem estoque")));
		}	
	}
	
	//Forma nova
	@Test
	public void testLocacao_filmeSemEstoque3() throws Exception {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme = FilmeBuilder.umFilmeSemEstoque().agora();
		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		
		//acao
		service.alugarFilme(usuario, filme);
	}
	
	@Test
	public void testLocacao_usuarioVazio() throws FilmeSemEstoqueException {
		//cenario
		Filme filme = FilmeBuilder.umFilme().agora();
		
		try {
			service.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), CoreMatchers.is(CoreMatchers.equalTo("Usuario vazio")));
		}
	}
	
	//serve para que o teste seja ignorado durante a execução dos testes.
	//usamos essa anotação quando queremos colocar algum metodo de teste em Stand by
	@Test
	@Ignore
	public void testLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		//cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		//acao
		service.alugarFilme(usuario, null);
		
	
	}
}
