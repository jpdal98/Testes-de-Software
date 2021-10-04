package br.ufc.TesteUnitarios;

import br.ufc.JDBC.ConnectionFactory;
import br.ufc.controllers.ClienteController;
import br.ufc.controllers.PetsController;
import br.ufc.controllers.PetshopController;
import br.ufc.controllers.ServiçoController;
import br.ufc.entities.Cliente;
import br.ufc.entities.Pets;
import br.ufc.entities.Serviços;

import static org.junit.Assert.*;

public class PetshopControllerTest {
    private PetshopController petshopController = new PetshopController(new ConnectionFactory());
    private PetsController petsController = new PetsController(new ConnectionFactory());
    private ClienteController clienteController = new ClienteController(new ConnectionFactory());
    private ServiçoController serviçoController = new ServiçoController(new ConnectionFactory());




    @org.junit.Test
    public void addDinheiroCaixa() {
        boolean resultado = petshopController.addDinheiroCaixa(50);
        assertTrue(resultado);

        boolean resultado2 = petshopController.addDinheiroCaixa(-200);
        assertFalse(resultado2);
    }

    @org.junit.Test
    public void removerDinheiroCaixa() {
        petshopController.addDinheiroCaixa(1000.0);
        boolean resultado = petshopController.removerDinheiroCaixa(200);
        assertTrue(resultado);

        boolean resultado2 = petshopController.removerDinheiroCaixa(1900);
        assertFalse(resultado2);


    }

    @org.junit.Test
    public void solicitarServiço(){
        Cliente cliente = new Cliente("Renato","12312312312","8812121212");
        clienteController.cadastrarCliente(cliente);

        Pets pet = new Pets("Fernando","auau", 5);
        petsController.cadastrarPet(pet);

        Serviços serviço = new Serviços("Banhar o auau", 30);
        petshopController.solicitarServiço(pet,serviço);
    }
}
