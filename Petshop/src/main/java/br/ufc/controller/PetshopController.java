package br.ufc.controller;

import br.ufc.model.Pets;
import br.ufc.model.Petshop;
import br.ufc.model.Servicos;

import java.util.List;

public class PetshopController {
    
	private Petshop petshop = new Petshop(0);
    private PetsController petsController = new PetsController();
    private ServicoController servicoController = new ServicoController();

    public double getCaixa(){
        return petshop.getCaixa();
    }

    public boolean addDinheiroCaixa(double dinheiro){
        if(dinheiro > 0){
            petshop.setCaixa(petshop.getCaixa() + dinheiro);
            return true;
        }
        return false;
    }

    public boolean removerDinheiroCaixa(double dinheiro){
        if((petshop.getCaixa() - dinheiro) >= 0 ){
            petshop.setCaixa(petshop.getCaixa() - dinheiro);
            return true;
        }
        return false;
    }

    public boolean solicitarServiço(Pets pet, Servicos serviço) {
        Pets pett = petsController.pegarUmPet(pet.getId());
        if (pett != null) {
            List<Servicos> serviços = petsController.pegarServiçosDoPet(pet);
            serviços.add(serviço);
            addDinheiroCaixa(serviço.getPreço());
            pet.setServiços(serviços);
            petsController.editarPet(pet, pet.getId());
            return true;
        }
        return false;
    }
}
