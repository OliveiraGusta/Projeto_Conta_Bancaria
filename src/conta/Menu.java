package conta;

import java.util.Scanner;

import conta.util.Colors;

public class Menu {

	public static void main(String[] args) {
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

						0 - Sair

					%s-----------------------------------------------------%s
					Entre com a opção desejada:""", Colors.TEXT_GREEN_BOLD, Colors.TEXT_WHITE_BOLD, Colors.TEXT_GREEN_BOLD, Colors.TEXT_RESET);
			option = scanner.nextInt();

			if (option == 9) {
				System.out.println("\nJavabank - Melhor banco para se estressar");
				about();
				scanner.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Criar Conta");
				System.out.println("---------------------------------------------");

				break;
			case 2:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Listar");
				System.out.println("---------------------------------------------");


				break;
			case 3:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Consulta por numero");
				System.out.println("---------------------------------------------");


				break;
			case 4:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Atualizar Conta");
				System.out.println("---------------------------------------------");


				break;
			case 5:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Apagar Conta");
				System.out.println("---------------------------------------------");


				break;
			case 6:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Saque");
				System.out.println("---------------------------------------------");


				break;
			case 7:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Depósito");
				System.out.println("---------------------------------------------");

				break;
			case 8:
				System.out.println(Colors.TEXT_WHITE_BOLD + "Transferência");
				System.out.println("---------------------------------------------");

				break;
			default:
				System.out.println(Colors.TEXT_RED_BOLD + "Opção Inválida!");
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
