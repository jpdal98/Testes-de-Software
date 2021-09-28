package br.ufc.controller;

import java.util.List;

import br.ufc.DAO.ClienteRepositorio;
import br.ufc.DAO.PetsRepositorio;
import br.ufc.model.Cliente;
import br.ufc.model.Pets;
import br.ufc.model.Servicos;


public class PetsController {
   
	PetsRepositorio petsRepositorio = PetsRepositorio.getInstance();
    ClienteRepositorio clienteRepositorio = ClienteRepositorio.getInstance();

    public boolean cadastrarPet(Pets pet) {
        if (validarPet(pet)) {
            petsRepositorio.addPet(pet);
            adicionarPetAoCliente(pet);
            return true;
        }
        return false;
    }

    public boolean removerPet(int id) {
        for (Pets pet : petsRepositorio.getPets()) {
            if (pet.getId() == id) {
                Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
                removerPetDoCliente(pet);
                petsRepositorio.removerPet(pet.getId());
                return true;
            }
        }
        return false;
    }

    public boolean editarPet(Pets pet, int id) {
        if (validarPet(pet)) {
            Pets editarPet = petsRepositorio.verificarPet(id);
            if (editarPet != null) {
                editarPet.setNome(pet.getNome());
                editarPet.setDono(pet.getDono());
                editarPet.setRaça(pet.getRaça());
                editarPet.setServiços(pet.getServiços());
                return true;
            }
        }
        return false;
    }

    public List<Pets> listarPet() {
        return petsRepositorio.getPets();

    }

    public boolean validarPet(Pets pet) {
        if (pet.getNome().equals("") || pet.getNome().matches(".*[[0-9]].*")) {
            return false;

        }
        if (pet.getDono() == null) {
            return false;
        }
        if (clienteRepositorio.verificarCliente(pet.getDono().getId()) == null) {
            return false;
        }
        if (pet.getRaça().equals("") || pet.getRaça().matches(".*[[0-9]].*")) {
            return false;
        }

        return true;
    }

    public boolean adicionarPetAoCliente(Pets pet) {
        Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
        if (cliente != null) {
            List<Pets> petsList = cliente.getPets();
            petsList.add(pet);
            cliente.setPets(petsList);
            clienteRepositorio.atualizarCliente(cliente, cliente.getId());
            return true;
        }
        return false;
    }

    public boolean removerPetDoCliente(Pets pet) {
        Cliente cliente = clienteRepositorio.verificarCliente(pet.getDono().getId());
        if (cliente != null) {
            List<Pets> petsList = cliente.getPets();
            petsList.remove(pet);
            cliente.setPets(petsList);
            clienteRepositorio.atualizarCliente(cliente, cliente.getId());
            return true;
        }
        return false;
    }
    public List<Servicos> pegarServiçosDoPet(Pets pet){
        Pets pett = petsRepositorio.verificarPet(pet.getId());
        if(pett != null){
            return pett.getServiços();
        }
        return null;
    }

    public Pets pegarUmPet(int id){
        Pets pet = petsRepositorio.verificarPet(id);
        if(pet != null){
            return pet;
        }
        return null;
    }
}
