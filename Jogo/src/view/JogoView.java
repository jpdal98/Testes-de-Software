package view;

import java.util.Scanner;

import controllers.JogoController;
import model.Jogo;

public class JogoView {
	
	public static void mostrarMenu() {
		System.out.println("Digite para ação:");
		System.out.println("1 - Adicionar");
		System.out.println("2 - Editar");
		System.out.println("3 - Remover");
		System.out.println("4 - Ver Todos os Jogos");
		System.out.println("5 - Ver Específico");
		System.out.println("6 - Sair");
	}
	
	public static void main(String[] args) {
		JogoController jogoController = new JogoController();
		System.out.println(jogoController.cadastrarJogo("test1", 10.0, "1", "1", "2020", "a@a.com"));
		System.out.println(jogoController.cadastrarJogo("test2", 10.0, "1", "1", "2020", "a@a.com"));
		System.out.println(jogoController.cadastrarJogo("test3", 10.0, "1", "1", "2020", "a@a.com"));
		System.out.println(jogoController.cadastrarJogo("test3", 10.0, "1", "1", "2020", "a@a.com"));
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		int opcao = 0;
		while(opcao != 6) {
			mostrarMenu();
			try {
				opcao = Integer.parseInt(myObj.nextLine());
			}catch (Exception e) {
				System.out.println(e.toString());
				continue;
			}
			switch (opcao) {
			case 1: {
				String nome = "";
				Double preco = -1.0;
				String dia = "";
				String mes = "";
				String ano = "";
				String email = "";
				
				System.out.println("Adicionar Jogo");
				
				System.out.println("Digite o nome do jogo: ");
				nome = myObj.nextLine();
				
				try {
					System.out.println("Digite o preco do jogo");
					preco = Double.parseDouble(myObj.nextLine());					
				}catch (Exception e) {
					System.out.println("Algo deu errado ao adicionar um preco");
					System.out.println(e.toString());
					break;
				}
				
				System.out.println("Digite o dia da compra do jogo: ");
				dia = myObj.nextLine();
				
				System.out.println("Digite o mes da compra do jogo: ");
				mes = myObj.nextLine();
				
				System.out.println("Digite o ano da compra do jogo: ");
				ano = myObj.nextLine();
				
				System.out.println("Digite o email da compra do jogo: ");
				email = myObj.nextLine();
				
				System.out.println("Nome: " + nome);
				System.out.println("Preco: " + preco);
				System.out.println("Dia: " + dia);
				System.out.println("Mes: " + mes);
				System.out.println("Ano: " + ano);
				System.out.println("Email: " + email);
				
				try {
					boolean confirmacao = jogoController.cadastrarJogo(nome, preco, dia, mes, ano, email);
					if(!confirmacao) {
						System.out.println("Algo deu errado ao cadastrar o jogo");
						break;
					}
					System.out.println("Adicionado com sucesso!!");
				}catch (Exception e) {
					System.out.println(e.toString());
					System.out.println("Um erro incomun aconteceu");
				}
				break;
			}
			case 2: {
				String nome = "";
				Double preco = -1.0;
				String dia = "";
				String mes = "";
				String ano = "";
				String email = "";
				int id = -1;
				
				System.out.println("Editar Jogo ");
				try {
					System.out.println("Digite o id para alterar");
					id = Integer.parseInt(myObj.nextLine());				
				}catch (Exception e) {
					System.out.println("Algo deu errado ao remover por id");
					System.out.println(e.toString());
					break;
				}
				
				System.out.println("Digite o nome do jogo: ");
				nome = myObj.nextLine();
				
				try {
					System.out.println("Digite o preco do jogo");
					preco = Double.parseDouble(myObj.nextLine());					
				}catch (Exception e) {
					System.out.println("Algo deu errado ao adicionar um preco");
					System.out.println(e.toString());
					break;
				}
				
				System.out.println("Digite o dia da compra do jogo: ");
				dia = myObj.nextLine();
				
				System.out.println("Digite o mes da compra do jogo: ");
				mes = myObj.nextLine();
				
				System.out.println("Digite o ano da compra do jogo: ");
				ano = myObj.nextLine();
				
				System.out.println("Digite o email da compra do jogo: ");
				email = myObj.nextLine();
				
				System.out.println("Nome: " + nome);
				System.out.println("Preco: " + preco);
				System.out.println("Dia: " + dia);
				System.out.println("Mes: " + mes);
				System.out.println("Ano: " + ano);
				System.out.println("Email: " + email);
				
				try {
					boolean confirmacao = jogoController.editarJogo(nome, preco, dia, mes, ano, email, id);
					if(!confirmacao) {
						System.out.println("Algo deu errado ao cadastrar o jogo");
						break;
					}
					System.out.println("Adicionado com sucesso!!");
				}catch (Exception e) {
					System.out.println(e.toString());
					System.out.println("Um erro incomun aconteceu");
				}
				break;			
			}
			case 3: {
				int id = -1;
				try {
					System.out.println("Digite o id para remover");
					id = Integer.parseInt(myObj.nextLine());				
				}catch (Exception e) {
					System.out.println("Algo deu errado ao remover por id");
					System.out.println(e.toString());
					break;
				}
				boolean encontrado = jogoController.removerJogo(id);
				if(!encontrado) {
					System.out.println("Jogo nao removido");
					break;
				}
				System.out.println("Jogo removido");
				break;				
			}
			case 4: {
				System.out.println("Jogos: ");
				for(Jogo jogo : jogoController.getJogos()) {
					System.out.println(jogo.toString());
				}
				break;				
			}
			case 5: {
				int id = -1;
				try {
					System.out.println("Digite o id para buscar");
					id = Integer.parseInt(myObj.nextLine());					
				}catch (Exception e) {
					System.out.println("Algo deu errado ao buscar por id");
					System.out.println(e.toString());
					break;
				}
				Jogo encontrado = jogoController.getJogoById(id);
				if(encontrado == null) {
					System.out.println("Jogo nao encontrado");
					break;
				}
				System.out.println(encontrado);
				break;				
			}
			case 6: {
				myObj.close();
				break;				
			}
			
			default:
				System.out.println("Unexpected value: " + opcao);
				break;
			}
		}
	    
	}
}
