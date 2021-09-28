package br.ufc.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.ufc.controller.JogoController;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
class JogoControllerTest {
	private JogoController jogoController = new JogoController();
	
	@Test
	@DisplayName("Adicionar Jogo Basic Test")
	@Order(1)
	void addJogoBasicTest() {
		assertTrue(jogoController.cadastrarJogo("test1", 19.90, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Null Test")
	@Order(2)
	void addJogoInvalidNomeNullTest() {
		assertFalse(jogoController.cadastrarJogo(null, 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Empty Test")
	@Order(2)
	void addJogoInvalidNomeEmptyTest() {
		assertFalse(jogoController.cadastrarJogo("", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Special Character Test")
	@Order(2)
	void addJogoInvalidNomeSpecialCharacterTest() {
		assertFalse(jogoController.cadastrarJogo("#Nome", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Comeca com Espaco Test")
	@Order(2)
	void addJogoInvalidNomeComecoEspacoTest() {
		assertFalse(jogoController.cadastrarJogo(" Nome", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Termina com Espaco Test")
	@Order(2)
	void addJogoInvalidNomeTerminaEspacoTest() {
		assertFalse(jogoController.cadastrarJogo("Nome ", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Preco Null Test")
	@Order(2)
	void addJogoInvalidPrecoNullTest() {
		assertFalse(jogoController.cadastrarJogo("Nome", null, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Preco Negative Test")
	@Order(2)
	void addJogoInvalidPrecoNegativeTest() {
		assertFalse(jogoController.cadastrarJogo("Nome", -1.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Date Null Test")
	@Order(2)
	void addJogoInvalidDateNullTest() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, null, null, null, "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email Null Test")
	@Order(2)
	void addJogoInvalidEmailNullTest() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", null));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email Empty Test")
	@Order(2)
	void addJogoInvalidEmailEmptyTest() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", ""));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 1 Test")
	@Order(2)
	void addJogoInvalidEmail1Test() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", "a@"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 2 Test")
	@Order(2)
	void addJogoInvalidEmail2Test() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", "a@a"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 3 Test")
	@Order(2)
	void addJogoInvalidEmail3Test() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", "@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 4 Test")
	@Order(2)
	void addJogoInvalidEmail4Test() {
		assertFalse(jogoController.cadastrarJogo("Nome", 10.0, "01", "02", "2011", "@.com"));
	}
	
	@Test
	@DisplayName("Get Jogos Basic Test")
	@Order(5)
	void listJogoBasicTest() {
		assertEquals(ArrayList.class, jogoController.getJogos().getClass());
	}
	
	@Test
	@DisplayName("Remover Jogo Basic Test")
	@Order(7)
	void removerJogoBasicTest() {
		assertTrue(jogoController.removerJogo(0));
	}
	
	@Test
	@DisplayName("Remove Jogo Id N�o Existe Test")
	@Order(8)
	void removeJogoNoExisteTest() {
		assertFalse(jogoController.removerJogo(100));
	}
	
	@Test
	@DisplayName("Remove Jogo Id Negativo Test")
	@Order(8)
	void removeJogoIdNegativoTest() {
		assertFalse(jogoController.removerJogo(-1));
	}
	
	@Test
	@DisplayName("Remove Jogo Id Nao Existe Test")
	@Order(8)
	void removeJogoIdNaoExisteTest() {
		assertFalse(jogoController.removerJogo(100));
	}
	
	@Test
	@DisplayName("Adicionar Jogo Para Proximos Testes")
	@Order(9)
	void addJogoParaProximosTestes() {
		assertTrue(jogoController.cadastrarJogo("test1", 19.90, "01", "02", "2011", "a@a.com"));
		assertTrue(jogoController.cadastrarJogo("test2", 11.90, "01", "02", "2011", "b@a.com"));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Nome Com Espaco Basic Test")
	@Order(10)
	void atualizarJogoNomeEspacoBasicTest() {
		assertTrue(jogoController.editarJogo("Jo0go 0", 10.0, "01", "02", "2011", "zero@zero.com" , 1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Nome Errado Test")
	@Order(10)
	void atualizarJogoNomeErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go# 0", 10.0, "01", "02", "2011", "zero@zero.com" , 1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Preco Errado Test")
	@Order(10)
	void atualizarJogoPrecoErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", -10.0, "01", "02", "2011", "zero@zero.com" , 1));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Dia Errado Test")
	@Order(10)
	void atualizarJogoDiaErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "32", "02", "2011", "zero@zero.com" , 1));
	} 

	@Test
	@DisplayName("Atualizar Jogo Mes Errado Test")
	@Order(10)
	void atualizarJogoMesErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "31", "13", "2011", "zero@zero.com" , 1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Ano Errado Test")
	@Order(10)
	void atualizarJogoAnoErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "31", "12", "2024", "zero@zero.com" , 1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Email Errado Test")
	@Order(10)
	void atualizarJogoEmailErradoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "31", "12", "2021", "@z ero.com" , 1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Id Negativo Test")
	@Order(10)
	void atualizarJogoIdNegativoTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "31", "12", "2021", "zero@zero.com" , -1));
	} 
	
	@Test
	@DisplayName("Atualizar Jogo Id Nao Existe Test")
	@Order(11)
	void atualizarJogoIdNaoExisteTest() {
		assertFalse(jogoController.editarJogo("Jo0go 0", 10.0, "31", "12", "2021", "zero@zero.com" , 100000));
	} 
	
	@Test
	@DisplayName("Get By ID Jogo Basic Test")
	@Order(11)
	void getByIdJogoBasicTest() {
		assertEquals("test2",jogoController.getJogoById(2).getNomeJogo());
	} 
	
	@Test
	@DisplayName("Get By ID Jogo Negativo Test")
	@Order(11)
	void getByIdJogoNegativoTest() {
		assertEquals(null, jogoController.getJogoById(-1));
	}
	
	@Test
	@DisplayName("Get By ID Jogo ID Nao Existe Test")
	@Order(11)
	void getByIdJogoIDNaoExisteTest() {
		assertEquals(null, jogoController.getJogoById(1000));
	}
}
