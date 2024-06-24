package bankAccount;

import java.util.InputMismatchException;
import java.util.Scanner;
import bankAccount.model.Account;
import bankAccount.model.AccountCurrent;
import bankAccount.model.AccountSavings;
import bankAccount.util.Colors;


public class Menu {

	public static void main(String[] args) {
		
		AccountSavings user1 = new AccountSavings(1, 2, 1, "Kelly", 10000.0f, 24);
		user1.viewAccountDetails();
		user1.withdraw(200.0f);
		user1.viewAccountDetails();
		user1.deposit(2000.0f);
		user1.viewAccountDetails();
		
		AccountCurrent user2 = new AccountCurrent(2, 1, 2, "Luis", 20000.0f, 300.0f);
		user2.viewAccountDetails();
		user2.withdraw(100.0f);
		user2.viewAccountDetails();
		user2.deposit(1000.0f);
		user2.viewAccountDetails();
		  
		
		Scanner scanner = new Scanner(System.in);
		int option;
		

		while (true) {
			System.out.printf("""
					%s-----------------------------------------------------

						Javabank - Melhor banco para se estressar

					-----------------------------------------------------%s 

						1 - Criar Conta
						2 - Listar todas as Contas
						3 - Buscar Conta por numero
						4 - Atualizar Dados da Conta
						5 - Apagar Conta
						6 - Sacar
						7 - Depositar
						8 - Transferir valores entre Contas
						
						9 - Fechar aplicação

					%s-----------------------------------------------------%s
					Entre com a opção desejada:""", Colors.TEXT_GREEN_BOLD, Colors.TEXT_WHITE_BOLD, Colors.TEXT_GREEN_BOLD, Colors.TEXT_RESET);
			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				option = 0;
			}
			

			if (option == 9) {
				System.out.println("\n\nJavabank - Melhor banco para se estressar");
				System.out.println("---------------------------------------------");
				System.out.println("Sair da aplicação");
				about();
				scanner.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nCriar Conta");
				System.out.println("---------------------------------------------");

				break;
			case 2:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nListar");
				System.out.println("---------------------------------------------");


				break;
			case 3:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nConsulta por numero");
				System.out.println("---------------------------------------------");


				break;
			case 4:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nAtualizar Conta");
				System.out.println("---------------------------------------------");


				break;
			case 5:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nApagar Conta");
				System.out.println("---------------------------------------------");


				break;
			case 6:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nSaque");
				System.out.println("---------------------------------------------");


				break;
			case 7:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nDepósito");
				System.out.println("---------------------------------------------");

				break;
			case 8:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nTransferência");
				System.out.println("---------------------------------------------");

				break;
			default:
				System.out.println(Colors.TEXT_RED_BOLD + "\n\nOpção Inválida!");
				System.out.println("---------------------------------------------");

				break;
			}

		}
	}

	public static void about() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println(Colors.TEXT_WHITE_BOLD +  "Gustavo Oliveira - gustavo.oliver456@gmail.com");
		System.out.println(Colors.TEXT_GREEN_BOLD + "github.com/OliveiraGusta");
		System.out.println("-----------------------------------------------------");
	}

}
