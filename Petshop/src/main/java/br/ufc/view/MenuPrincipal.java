package br.ufc.view;

import java.util.Scanner;

import br.ufc.utils.GeradorClientes;
import br.ufc.utils.GeradorPets;
import br.ufc.utils.GeradorServico;

public class MenuPrincipal {

    public static void main(String[] args) {
        
    	int chave = 0;
        MenuADM menuADM = new MenuADM();
        MenuCliente menuCliente = new MenuCliente();
        Scanner sc = new Scanner(System.in);
        GeradorClientes geradorClients = new GeradorClientes();
        GeradorPets geradorPets = new GeradorPets();
        GeradorServico geradorServiço = new GeradorServico();
        geradorClients.criarClientes();
        geradorPets.gerarPets();
        geradorServiço.geradorServiço();

        System.out.println("Digite 1 se você for administrador, digite 2 se você for cliente");
        chave = sc.nextInt();
        while (true) {

            switch (chave) {
                case 1:
                    menuADM.mostrarMenu();
                    break;
                case 2:
                    menuCliente.mostrarMenu();
                    break;
                case -1:
                    return;
                default:
                    break;
            }
        }
    }


}
