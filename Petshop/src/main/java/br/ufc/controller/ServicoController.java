package br.ufc.controller;

import java.util.List;

import br.ufc.DAO.ServicosRepositorio;
import br.ufc.model.Servicos;

public class ServicoController {
   
	ServicosRepositorio serviçosRepositorio = ServicosRepositorio.getInstance();

    public boolean criarServiço(Servicos serviço) {
        if(validarServiço(serviço)){
            serviçosRepositorio.addServiço(serviço);
            return true;
        }
        return false;

    }

    public boolean removerServiço(int id) {
       Servicos removerServiço = serviçosRepositorio.VerificarServiço(id);
       if(removerServiço != null){
           serviçosRepositorio.removerServiço(removerServiço.getId());
           return true;
       }
       return false;
    }

    public boolean editarServiço(Servicos serviço, int id) {
        if(validarServiço(serviço)){
            Servicos editarServiço = serviçosRepositorio.VerificarServiço(id);
            if(editarServiço != null){
                editarServiço.setPreço(serviço.getPreço());
                editarServiço.setNomeServiço(serviço.getNomeServiço());
                return true;
            }
        }

        return false;
    }

    public List<Servicos> mostrarServiços() {
        return serviçosRepositorio.getServiços();
    }

    public boolean validarServiço(Servicos serviço) {
        if (serviço.getNomeServiço().equals("")|| serviço.getNomeServiço().matches(".*[0-9].*")){
            return false;
        }
        if (serviço.getPreço() <= 0) {
            return false;
        }
        return true;
    }
    public Servicos pegarUmServiço(int id){
        return serviçosRepositorio.VerificarServiço(id);
    }
}
