package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.After;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import DAO.JogoRepository;
import model.Jogo;

@TestMethodOrder(OrderAnnotation.class)
class JogoRepositoryTest {
	private JogoRepository repo = JogoRepository.getInstance();
	
	
	@Test
	@DisplayName("Get Jogos Creation Test")
	@Order(1)
	void getJogoTest() {
		assertTrue(repo.getJogos().isEmpty());
	}
	
	@Test
	@DisplayName("Add Jogo Basic Test")
	@Order(2)
	void addJogoTest() {
		assertTrue(repo.addJogo("test1", 19.90, "01", "02", "2011", "a@a.com"));
		assertTrue(repo.addJogo("test2", 19.90, "01", "02", "2011", "b@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Null Test")
	@Order(2)
	void addJogoInvalidNomeNullTest() {
		assertFalse(repo.addJogo(null, 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Empty Test")
	@Order(2)
	void addJogoInvalidNomeEmptyTest() {
		assertFalse(repo.addJogo("", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Nome Special Character Test")
	@Order(2)
	void addJogoInvalidNomeSpecialCharacterTest() {
		assertFalse(repo.addJogo("#Nome", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Preco Null Test")
	@Order(2)
	void addJogoInvalidPrecoNullTest() {
		assertFalse(repo.addJogo("Nome", null, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Preco Negative Test")
	@Order(2)
	void addJogoInvalidPrecoNegativeTest() {
		assertFalse(repo.addJogo("Nome", -1.0, "01", "02", "2011", "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Date Null Test")
	@Order(2)
	void addJogoInvalidDateNullTest() {
		assertFalse(repo.addJogo("Nome", 10.0, null, null, null, "a@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email Null Test")
	@Order(2)
	void addJogoInvalidEmailNullTest() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", null));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email Empty Test")
	@Order(2)
	void addJogoInvalidEmailEmptyTest() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", ""));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 1 Test")
	@Order(2)
	void addJogoInvalidEmail1Test() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", "a@"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 2 Test")
	@Order(2)
	void addJogoInvalidEmail2Test() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", "a@a"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 3 Test")
	@Order(2)
	void addJogoInvalidEmail3Test() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", "@a.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Invalid Email 4 Test")
	@Order(2)
	void addJogoInvalidEmail4Test() {
		assertFalse(repo.addJogo("Nome", 10.0, "01", "02", "2011", "@.com"));
	}
	
	@Test
	@DisplayName("Add Jogo Repetido Test")
	@Order(3)
	void addJogoRepetidoTest() {
		assertFalse(repo.addJogo("test1", 10.0, "01", "02", "2011", "a@a.com"));
	}
	
	
	@Test
	@DisplayName("List Jogo Basic Test")
	@Order(3)
	void listJogoTest() {
		for(Jogo jogo : repo.getJogos()) {
			System.out.println(jogo.toString());
		}
		assertEquals(ArrayList.class, repo.getJogos().getClass());
	}
	
	@Test
	@DisplayName("Find Jogo Id Basic Test")
	@Order(4)
	void findJogoTest() {
		repo.addJogo("test3", 12.70, "01", "02", "2011", "c@a.com");
		assertEquals("test3", repo.findJogo(2).getNomeJogo());
	}
	
	@Test
	@DisplayName("Find Jogo Id Passando do Vetor Test")
	@Order(5)
	void findJogoPassandoTest() {
		assertEquals(null, repo.findJogo(4));
	}
	
	@Test
	@DisplayName("Find Jogo Id Negativo Test")
	@Order(6)
	void findJogoNegativoTest() {
		assertEquals(null, repo.findJogo(-1));
	}
	
	@Test
	@DisplayName("Find Jogo Id Zero Test")
	@Order(7)
	void findJogoZeroTest() {
		assertEquals(Jogo.class, repo.findJogo(0).getClass());
	}
	
	@Test
	@DisplayName("Remove Jogo Basic Test")
	@Order(8)
	void removeJogoTest() {
		assertTrue(repo.removerJogo(1));
	}
	
	@Test
	@DisplayName("Remove Jogo Id Não Existe Test")
	@Order(9)
	void removeJogoNãoExisteTest() {
		assertFalse(repo.removerJogo(1));
	}
	
	@Test
	@DisplayName("Remove Jogo Id Negativo Test")
	@Order(9)
	void removeJogoIdNegativoTest() {
		assertFalse(repo.removerJogo(-1));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Basic Test")
	@Order(11)
	void atualizarJogoBasicTest() {
		assertTrue(repo.atualizarJogo("test4", 10.0, "01", "02", "2011", "d@a.com" , 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Nome Null Test")
	@Order(12)
	void atualizarJogoInvalidNomeNullTest() {
		assertFalse(repo.atualizarJogo(null, 10.0, "01", "02", "2011", "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Nome Empty Test")
	@Order(12)
	void atualizarJogoInvalidNomeEmptyTest() {
		assertFalse(repo.atualizarJogo("", 10.0, "01", "02", "2011", "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Nome Special Character Test")
	@Order(12)
	void atualizarJogoInvalidNomeSpecialCharacterTest() {
		assertFalse(repo.atualizarJogo("#Nome", 10.0, "01", "02", "2011", "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Preco Null Test")
	@Order(12)
	void atualizarJogoInvalidPrecoNullTest() {
		assertFalse(repo.atualizarJogo("Nome", null, "01", "02", "2011", "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Preco Negative Test")
	@Order(12)
	void atualizarJogoInvalidPrecoNegativeTest() {
		assertFalse(repo.atualizarJogo("Nome", -1.0, "01", "02", "2011", "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Date Null Test")
	@Order(12)
	void atualizarJogoInvalidDateNullTest() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, null, null, null, "a@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email Null Test")
	@Order(12)
	void atualizarJogoInvalidEmailNullTest() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", null, 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email Empty Test")
	@Order(12)
	void atualizarJogoInvalidEmailEmptyTest() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", "", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email 1 Test")
	@Order(12)
	void atualizarJogoInvalidEmail1Test() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", "a@", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email 2 Test")
	@Order(12)
	void atualizarJogoInvalidEmail2Test() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", "a@a", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email 3 Test")
	@Order(12)
	void atualizarJogoInvalidEmail3Test() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", "@a.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Invalid Email 4 Test")
	@Order(12)
	void atualizarJogoInvalidEmail4Test() {
		assertFalse(repo.atualizarJogo("Nome", 10.0, "01", "02", "2011", "@.com", 0));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Id Negativo Test")
	@Order(13)
	void atualizaJogoIdNegativoTest() {
		assertFalse(repo.atualizarJogo("test5", 10.0, "01", "02", "2011", "a@a.com", -1));
	}
	
	@Test
	@DisplayName("Atualizar Jogo Id Passando do Array Test")
	@Order(14)
	void atualizaJogoIdPassandoTest() {
		assertFalse(repo.atualizarJogo("test6", 10.0, "01", "02", "2011", "a@a.com", 100));
	}

	@After
	void tearDown() {
		this.repo = null;
	}

}
