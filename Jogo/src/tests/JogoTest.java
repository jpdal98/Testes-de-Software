package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import model.Jogo;

@TestMethodOrder(OrderAnnotation.class)
class JogoTest {
	private Jogo jogoTest;
	
	@BeforeEach
	void setUp() {
		jogoTest = new Jogo();
		jogoTest.setId(1);
		jogoTest.setNomeJogo("Nome");
		jogoTest.setPrecoJogo(19.0);
		jogoTest.setDataCompra("01", "02", "2011");
		jogoTest.setEmail("aluno@ufc.com");
	}
	
	@Test
	@DisplayName("Get Set Nome Basic Test")
	@Order(1)
	void getSetNomeBasicTest() {
		assertTrue(jogoTest.setNomeJogo("Joguinho"));
	}
	
	@Test
	@DisplayName("Get Set Nome Null Test")
	@Order(2)
	void getSetNomeNullTest() {
		assertFalse(jogoTest.setNomeJogo(null));
	}
	
	@Test
	@DisplayName("Get Set Nome Space Test")
	@Order(2)
	void getSetNomeSpaceTest() {
		assertFalse(jogoTest.setNomeJogo("   "));
	}
	
	@Test
	@DisplayName("Get Set Nome Space Inicio Test")
	@Order(2)
	void getSetNomeSpaceInicioTest() {
		assertFalse(jogoTest.setNomeJogo(" Nome"));
	}
	
	@Test
	@DisplayName("Get Set Nome Space Fim Test")
	@Order(2)
	void getSetNomeSpaceFimTest() {
		assertFalse(jogoTest.setNomeJogo("Nome "));
	}
	
	@Test
	@DisplayName("Get Set Nome Empty Test")
	@Order(3)
	void getSetNomeEmptyTest() {
		jogoTest.setNomeJogo("");
		assertNotEquals("", jogoTest.getNomeJogo());
	}
	
	@Test
	@DisplayName("Get Set Nome Special Character Test")
	@Order(5)
	public void getSetNomeSpecialTest() {
		assertFalse(jogoTest.setNomeJogo("Jogo#"));
	}
	
	@Test
	@DisplayName("Get Set Id Basic Test")
	@Order(6)
	public void getSetIdBasicTest() {
		assertTrue(jogoTest.setId(10));
	}
	
	@Test
	@DisplayName("Get Set Id Negative Test")
	@Order(7)
	public void getSetIdNegativeTest() {
		
		assertFalse(jogoTest.setId(-1));
	}
	
	@Test
	@DisplayName("Get Set Preco Basic Test")
	@Order(9)
	public void getSetPrecoBasicTest() {
		assertTrue(jogoTest.setPrecoJogo(0.1));
	}
	
	@Test
	@DisplayName("Get Set Preco Negative Test")
	@Order(10)
	public void getSetPrecoNegativeTest() {
		jogoTest.setPrecoJogo(-0.1);
		assertNotEquals(-0.1, jogoTest.getPrecoJogo(), 0.0001);
	}
	
	@Test
	@DisplayName("Get Set Preco Null Test")
	@Order(10)
	public void getSetPrecoNullTest() {
		assertFalse(jogoTest.setPrecoJogo(null));
	}
	
	@Test
	@DisplayName("Get Date Basic Now Test")
	@Order(11)
	public void getDateBasicTest() {
		assertEquals(Date.class, jogoTest.getDataCompra().getClass());
	}
	
	@Test
	@DisplayName("Set Date Basic Now Test")
	@Order(11)
	public void setDateBasicTest() {
		assertTrue(jogoTest.setDataCompra("01", "12", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Dia Null Test")
	@Order(12)
	public void getSetDateDiaNullTest() {
		assertFalse(jogoTest.setDataCompra(null, "02", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Null Test")
	@Order(12)
	public void getSetDateMesNullTest() {
		assertFalse(jogoTest.setDataCompra("01", null, "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Ano Null Test")
	@Order(12)
	public void getSetDateAnoNullTest() {
		assertFalse(jogoTest.setDataCompra("01", "02", null));
	}
	
	@Test
	@DisplayName("Get Set Date Dia Negativo Test")
	@Order(12)
	public void getSetDateDiaNegativoTest() {
		assertFalse(jogoTest.setDataCompra("-1", "02", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Negativo Test")
	@Order(12)
	public void getSetDateMesNegativoTest() {
		assertFalse(jogoTest.setDataCompra("1", "-2", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Negativo Test")
	@Order(12)
	public void getSetDateAnoNegativoTest() {
		assertFalse(jogoTest.setDataCompra("1", "2", "-2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Dia Caractere Especial Test")
	@Order(12)
	public void getSetDateDiaCaractereEspecialTest() {
		assertFalse(jogoTest.setDataCompra("#1", "2", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Caractere Especial Test")
	@Order(12)
	public void getSetDateMesCaractereEspecialTest() {
		assertFalse(jogoTest.setDataCompra("1", "#2", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Ano Caractere Especial Test")
	@Order(12)
	public void getSetDateAnoCaractereEspecialTest() {
		assertFalse(jogoTest.setDataCompra("1", "2", "#2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Dia Vazio Test")
	@Order(12)
	public void getSetDateDiaVazioTest() {
		assertFalse(jogoTest.setDataCompra("", "2", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Vazio Test")
	@Order(12)
	public void getSetDateMesVazioTest() {
		assertFalse(jogoTest.setDataCompra("1", "", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Ano Vazio Test")
	@Order(12)
	public void getSetDateAnoVazioTest() {
		assertFalse(jogoTest.setDataCompra("1", "2", ""));
	}
	
	@Test
	@DisplayName("Get Set Date Dia Nao Existe Test")
	@Order(12)
	public void getSetDateDiaNaoExisteTest() {
		assertFalse(jogoTest.setDataCompra("32", "2", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Mes Nao Existe Test")
	@Order(12)
	public void getSetDateMesNaoExisteTest() {
		assertFalse(jogoTest.setDataCompra("1", "13", "2011"));
	}
	
	@Test
	@DisplayName("Get Set Date Ano Passado Nao Permitido Test")
	@Order(12)
	public void getSetDateAnoForaEscopoPassadoTest() {
		assertFalse(jogoTest.setDataCompra("1", "12", "1500"));
	}
	
	@Test
	@DisplayName("Get Set Date Ano Futuro Nao Permitido Test")
	@Order(12)
	public void getSetDateAnoForaEscopoFuturoTest() {
		assertFalse(jogoTest.setDataCompra("1", "12", "2024"));
	}
	
	@Test
	@DisplayName("Get Set Email Basic Test")
	@Order(13)
	public void getSetEmailBasicTest() {
		assertTrue(jogoTest.setEmail("a@a.com"));
	}
	
	@Test
	@DisplayName("Get Set Email Null Test")
	@Order(14)
	public void getSetEmailNullTest() {
		assertFalse(jogoTest.setEmail(null));
	}
	
	@Test
	@DisplayName("Get Set Email Empty Test")
	@Order(15)
	public void getSetEmailEmptyTest() {
		assertFalse(jogoTest.setEmail(""));
	}
	
	@Test
	@DisplayName("Get Set Email Invalid 1 Test")
	@Order(16)
	public void getSetEmailInvalid1Test() {
		assertFalse(jogoTest.setEmail("a@"));
	}
	
	@Test
	@DisplayName("Get Set Email Invalid 2 Test")
	@Order(17)
	public void getSetEmailInvalid2Test() {
		assertFalse(jogoTest.setEmail("@a"));
	}
	
	@Test
	@DisplayName("Get Set Email Invalid 3 Test")
	@Order(18)
	public void getSetEmailInvalid3Test() {
		assertFalse(jogoTest.setEmail("a@a"));
	}
	
	@Test
	@DisplayName("Get Set Email Space Test")
	@Order(19)
	public void getSetEmailSpaceTest() {
		assertFalse(jogoTest.setEmail("a @a.com"));
	}
	
	@Test
	@DisplayName("Get Set Email Enter Test")
	@Order(20)
	public void getSetEmailEnterTest() {
		assertFalse(jogoTest.setEmail("a\n@a.com"));
	}
	
	@Test
	@DisplayName("Get Set Email Tab Test")
	@Order(21)
	public void getSetEmailTabTest() {
		assertFalse(jogoTest.setEmail("a\t@a.com"));
	}
	
	@Test
	@DisplayName("Get Set Email Carriage Return Test")
	@Order(22)
	public void getSetEmailCarriageTest() {
		assertFalse(jogoTest.setEmail("a\r@a.com"));
	}
	
	@AfterEach
	void tearDown() {
		this.jogoTest = null;
	}

}
