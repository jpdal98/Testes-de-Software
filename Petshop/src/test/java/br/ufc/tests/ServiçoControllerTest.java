package br.ufc.tests;

import java.util.List;

import org.junit.Test;

import br.ufc.controller.ServicoController;
import br.ufc.model.Servicos;

import static org.junit.Assert.*;

public class ServiçoControllerTest {
   
	private ServicoController serviçoController = new ServicoController();
    
	@Test
    public void criarServiço() {

        boolean resultado = serviçoController.criarServiço(new Servicos("", (float) 20));
        assertFalse(resultado);
        boolean resultado2 = serviçoController.criarServiço(new Servicos("Cortar 2 Unhas", 30));
        assertFalse(resultado2);
        boolean resultado3 = serviçoController.criarServiço(new Servicos("Tosar", -15.5));
        assertFalse(resultado3);

        boolean resultado4 = serviçoController.criarServiço(new Servicos("Banho", 20));
        assertTrue(resultado4);
        boolean resultado5 = serviçoController.criarServiço(new Servicos("Cortar Unhas", 30));
        assertTrue(resultado5);
        boolean resultado6 = serviçoController.criarServiço(new Servicos("Tosar", 15.5));
        assertTrue(resultado6);
        boolean resultado7 = serviçoController.criarServiço(new Servicos("Aplicar Injeção", 11.5));
        assertTrue(resultado7);
    }

    @Test
    public void removerServiço() {
        serviçoController.criarServiço(new Servicos("teste", 20));
        assertTrue(serviçoController.removerServiço(1));
    }

    @Test
    public void editarServiço() {
        boolean resultado = serviçoController.criarServiço(new Servicos("teste", 20));
        assertTrue(resultado);

        Servicos editServiço = new Servicos("testeeditado", 30);
        boolean resultado2 = serviçoController.editarServiço(editServiço,1);
        assertTrue(resultado2);

        Servicos editServiço2 = new Servicos("",40);
        boolean resultado3 = serviçoController.editarServiço(editServiço2,1);
        assertFalse(resultado3);

    }

    @Test
    public void mostrarServiços() {
        serviçoController.criarServiço(new Servicos("testee",30));
        serviçoController.criarServiço(new Servicos("testeee",40));
        List<Servicos> serviços = serviçoController.mostrarServiços();
        for (Servicos serviço: serviços
             ) {
            System.out.println(serviço.toString());
        }
    }

    @Test
    public void validarServiço() {
        boolean resultado = serviçoController.validarServiço(new Servicos("", (float) 20));
        assertFalse(resultado);
        boolean resultado2 = serviçoController.validarServiço(new Servicos("Cortar 2 Unhas", 30));
        assertFalse(resultado2);
        boolean resultado3 = serviçoController.validarServiço(new Servicos("Tosar", -15.5));
        assertFalse(resultado3);

        boolean resultado4 = serviçoController.validarServiço(new Servicos("Banho", 20));
        assertTrue(resultado4);
        boolean resultado5 = serviçoController.validarServiço(new Servicos("Cortar Unhas", 30));
        assertTrue(resultado5);
        boolean resultado6 = serviçoController.validarServiço(new Servicos("Tosar", 15.5));
        assertTrue(resultado6);
        boolean resultado7 = serviçoController.validarServiço(new Servicos("Aplicar Injeção", 11.5));
        assertTrue(resultado7);

    }


}