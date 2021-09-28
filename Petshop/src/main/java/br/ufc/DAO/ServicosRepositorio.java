package br.ufc.DAO;

import java.util.ArrayList;
import java.util.List;

import br.ufc.model.Servicos;


public class ServicosRepositorio {
   
	private static ServicosRepositorio serviçosRepositorio;
    private List<Servicos> serviços = new ArrayList<Servicos>();

    public static ServicosRepositorio getInstance() {
        if (serviçosRepositorio == null) {
            serviçosRepositorio = new ServicosRepositorio();
        }
        return serviçosRepositorio;
    }

    public void addServiço(Servicos serviço){
        int ultimoID = 1;
        for(int i=0; i<serviços.size(); i++){
            ultimoID++;
        }
        serviço.setId(ultimoID);
        serviços.add(serviço);
    }

    public boolean removerServiço(int id){
        Servicos removerServiço = VerificarServiço(id);
        if(removerServiço != null){
            serviços.remove(removerServiço);
            return true;
        }
        return false;
    }

    public void atualizarServiço(Servicos serviço, int id){
        Servicos atualizarServiço = VerificarServiço(id);
        if(atualizarServiço != null){
            atualizarServiço.setNomeServiço(serviço.getNomeServiço());
            atualizarServiço.setPreço(serviço.getPreço());
        }
    }

    public List<Servicos> mostrarServiços(){
        return serviços;
    }

    public Servicos VerificarServiço(int id){
        for (Servicos serviço: serviços ) {
            if(serviço.getId() == id){
                return serviço;
            }
        }
        return null;
    }


    public List<Servicos> getServiços() {
        return serviços;
    }

    public void setServiços(List<Servicos> serviços) {
        this.serviços = serviços;
    }

}
