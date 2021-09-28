package br.ufc.utils;

import br.ufc.controller.ServicoController;
import br.ufc.model.Servicos;

public class GeradorServico {
   
	private ServicoController serviçoController = new ServicoController();

    public void geradorServiço(){
        serviçoController.criarServiço(new Servicos("Banho", (float) 20));
        serviçoController.criarServiço(new Servicos("Cortar Unhas", (float) 30));
        serviçoController.criarServiço(new Servicos("Tosar", (float) 15.5));
        serviçoController.criarServiço(new Servicos("Aplicar Injeção", (float) 11.5));
    }
}
