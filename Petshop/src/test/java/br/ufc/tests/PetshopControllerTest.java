package br.ufc.tests;


import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.controller.ClienteController;
import br.ufc.controller.PetsController;
import br.ufc.controller.PetshopController;
import br.ufc.controller.ServicoController;
import br.ufc.model.Cliente;
import br.ufc.model.Pets;
import br.ufc.model.Servicos;

public class PetshopControllerTest {
    
	private PetshopController petshopController = new PetshopController();
    private PetsController petsController = new PetsController();
    private ClienteController clienteController = new ClienteController();
    private ServicoController serviçoController = new ServicoController();
    
    @Test
    public void addDinheiroCaixa() {
        boolean resultado = petshopController.addDinheiroCaixa(50);
        assertTrue(resultado);

        boolean resultado2 = petshopController.addDinheiroCaixa(-200);
        assertFalse(resultado2);
    }

    @Test
    public void removerDinheiroCaixa() {
        petshopController.addDinheiroCaixa(1000.0);
        boolean resultado = petshopController.removerDinheiroCaixa(200);
        assertTrue(resultado);

        boolean resultado2 = petshopController.removerDinheiroCaixa(1900);
        assertFalse(resultado2);


    }

    @Test
    public void solicitarServiço(){
        Cliente cliente = new Cliente("Renato","12312312312","8812121212");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Fernando","auau", cliente);
        petsController.cadastrarPet(pet);

        Servicos serviço = new Servicos("Banhar o auau", 30);
        petshopController.solicitarServiço(pet,serviço);
    }
}