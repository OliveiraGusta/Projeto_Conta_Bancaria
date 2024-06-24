package bankAccount;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import bankAccount.contoller.bankAccountController;
import bankAccount.model.AccountCurrent;
import bankAccount.model.AccountSavings;
import bankAccount.util.Colors;

public class Menu {

	public static void main(String[] args) {

		bankAccountController accounts = new bankAccountController();

		Scanner scanner = new Scanner(System.in);
		int option, number, agency, type, birthday;
		String holderName;
		float balance, creditLimit;

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
					Entre com a opção desejada:""", Colors.TEXT_GREEN_BOLD, Colors.TEXT_WHITE_BOLD,
					Colors.TEXT_GREEN_BOLD, Colors.TEXT_RESET);
			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				option = 0;
			}

			if (option == 9) {
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nJavabank - Melhor banco para se estressar");
				System.out.println("---------------------------------------------" + Colors.TEXT_RESET);
				System.out.println("Sair da aplicação");
				about();
				scanner.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nCriar Conta");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);
				System.out.printf("\nDigite o Numero da Agência: ");
				agency = scanner.nextInt();
				System.out.printf("\nDigite o Nome do Titular: ");
				scanner.skip("\\R?");
				holderName = scanner.nextLine();

				do {
					System.out.printf("""
							\n\nLista Tipos de Conta:
							---------------------------------------------
							1 - Conta Corrente
							2 - Conta Poupança

							Digite o código do tipo de Conta:  """);
					type = scanner.nextInt();
				} while (type != 1 && type != 2);

				System.out.printf("\nDigite o Saldo da Conta R$");
				balance = scanner.nextFloat();

				switch (type) {
				case 1 -> {
					System.out.printf("\nDigite o Limite de Crédito R$");
					creditLimit = scanner.nextFloat();
					accounts.create(
							new AccountCurrent(accounts.newNumber(), agency, type, holderName, balance, creditLimit));
				}
				case 2 -> {
					System.out.printf("\nDigite o dia do Aniversario da Conta: ");
					birthday = scanner.nextInt();
					accounts.create(
							new AccountSavings(accounts.newNumber(), agency, type, holderName, balance, birthday));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nListar todas as Contas");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);
				accounts.listAll();

				keyPress();
				break;
			case 3:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nConsulta por numero");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);
				System.out.printf("Digite o número da Conta: ");
				number = scanner.nextInt();
				accounts.findByNumber(number);

				keyPress();
				break;
			case 4:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nAtualizar Conta");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);

				System.out.println("Digite o número da conta: ");
				number = scanner.nextInt();
				var searchAccount = accounts.searchInColletion(number);

				if (searchAccount != null) {
					System.out.printf("\nDigite o Numero da Agência: ");
					agency = scanner.nextInt();
					System.out.printf("\nDigite o Nome do Titular: ");
					scanner.skip("\\R?");
					holderName = scanner.nextLine();

					do {
						System.out.printf("""
								\n\nLista Tipos de Conta:
								---------------------------------------------
								1 - Conta Corrente
								2 - Conta Poupança

								Digite o código do tipo de Conta:  """);
						type = scanner.nextInt();
					} while (type != 1 && type != 2);

					System.out.printf("\nDigite o Saldo da Conta R$");
					balance = scanner.nextFloat();

					switch (type) {
					case 1 -> {
						System.out.printf("\nDigite o Limite de Crédito R$");
						creditLimit = scanner.nextFloat();
						
						accounts.update(new AccountCurrent(number, agency, type, holderName, balance, creditLimit));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						birthday = scanner.nextInt();
						
						accounts.update(new AccountSavings(number, agency, type, holderName, balance, birthday));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("\nA Conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nApagar Conta");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);
				number = scanner.nextInt();
				accounts.delete(number);
				
				keyPress();
				break;
			case 6:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nSaque");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);

				keyPress();
				break;
			case 7:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nDepósito");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);

				keyPress();
				break;
			case 8:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nTransferência");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);

				keyPress();
				break;
			default:
				System.out.println(Colors.TEXT_RED_BOLD + "\n\nOpção Inválida!");
				System.out.println("---------------------------------------------"+ Colors.TEXT_RESET);

				keyPress();
				break;
			}

		}

	}

	public static void about() {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println(Colors.TEXT_WHITE_BOLD + "Gustavo Oliveira - gustavo.oliver456@gmail.com");
		System.out.println(Colors.TEXT_GREEN_BOLD + "github.com/OliveiraGusta");
		System.out.println("-----------------------------------------------------");
	}

	public static void keyPress() {
		try {

			System.out.println(Colors.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}