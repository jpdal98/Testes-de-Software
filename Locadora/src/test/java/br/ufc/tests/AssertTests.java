package br.ufc.tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import br.ufc.entities.Usuario;

public class AssertTests {

	@Test
	public void tests() {
		
		//usado para verificar se um valor é verdadeiro
		Assert.assertTrue(true);
		
		//usado para verificar se um valor é falson
		Assert.assertFalse(false);
		
		//usado para checar se um valor é igual ao outro
		//obs: sempre que for realizar comparações com valores do tipo primitivo Double
		//passar como parametro um terceiro valor. Esse valor será a margem de erro
		//obs: no assertEquals, o primeiro valor é o valor que eu espero receber como resposta,
		//já o segundo valor é referente ao valor atual, ou seja, o valor que eu recebi.
		Assert.assertEquals("Erro de comparação", 1, 1);
		Assert.assertEquals("Erro de comparação", 0.51, 0.51, 0.1);
		Assert.assertEquals("Erro de comparação", Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals("Erro de comparação", Integer.valueOf(i), i2);
		Assert.assertEquals("Erro de comparação", i, i2.intValue());
		
		Assert.assertEquals("Erro de comparação", "bola", "bola");
		Assert.assertNotEquals("Erro de comparação", "bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase( "Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		//para conseguir testar se um obj é igual a outro obj, é necessário 
		//criar o metodo equals na classe do obj.
		Usuario user1 = new Usuario("pedro");
		Usuario user2 = new Usuario("pedro");
		Usuario user3 = user2;
		Usuario user4 = null;
				
		Assert.assertEquals(user1, user2);
		
		//comparação de obj a nivel de instância
		Assert.assertSame(user3, user2);
		Assert.assertNotSame(user1, user2);
		
		//Saber se um obj é nulo
		Assert.assertTrue(user4 == null);
		//ou
		Assert.assertFalse(user4 != null);
		//ou
		Assert.assertNull(user4);
		
		//Verificar se o obj n esta vazio
		Assert.assertNotNull(user1);
		
		//Verifque se o valor 2 é igual a 2
		Assert.assertThat(2, CoreMatchers.is(CoreMatchers.equalTo(2)));
	}
}
