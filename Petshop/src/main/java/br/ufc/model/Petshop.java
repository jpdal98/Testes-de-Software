package br.ufc.model;

import java.util.ArrayList;
import java.util.List;

public class Petshop {
    
	private double caixa;
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Servicos> serviços = new ArrayList<Servicos>();

    public Petshop(double caixa) {
        this.caixa = caixa;
    }

    public double getCaixa() {
        return caixa;
    }

    public void setCaixa(double caixa) {
        this.caixa = caixa;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setServiços(List<Servicos> serviços) {
        this.serviços = serviços;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public boolean addCliente(Cliente cliente){
        return clientes.add(cliente);
    }

    public boolean removerCliente(Cliente cliente){
        return clientes.remove(cliente);
    }

    public List<Servicos> getServiços() {
        return serviços;
    }

    public boolean addServiço(Servicos serviço){
        return serviços.add(serviço);
    }

    public boolean removerServiço(Servicos serviço){
        return serviços.remove(serviço);
    }
}
