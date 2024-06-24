package bankAccount.contoller;

import java.util.ArrayList;

import bankAccount.model.Account;
import bankAccount.repository.BankAccountRepository;

public class bankAccountController implements BankAccountRepository{

	private ArrayList<Account> listAccounts = new ArrayList<Account>();
	int number = 0;
	
	@Override
	public void findByNumber(int number) {
		var account = searchInColletion(number);
		
		if(account != null)
			account.viewAccountDetails();
		else
			System.out.println("\nA Conta número (" + number + ") não foi encontrado!" );
		
	}

	@Override
	public void listAll() {
		for(var account: listAccounts) {
			account.viewAccountDetails();
		}
	}

	@Override
	public void create(Account account) {
		listAccounts.add(account);
		System.out.println("\nA Conta número (" + account.getNumber() + ") foi criada com sucesso!");
		
	}

	@Override
	public void update(Account account) {
		var searchAccount = searchInColletion(account.getNumber());
		
		if(searchAccount != null) {
			listAccounts.set(listAccounts.indexOf(searchAccount), account);
			System.out.println("\nA Conta número (" + account.getNumber() + ") com o titular  " + account.getHolderName() + " foi atualizada com sucesso!");
		}else
			System.out.println("\nA Conta número (" + account.getNumber() + ") não foi encontrado!");	
	}

	@Override
	public void delete(int number) {
		var account = searchInColletion(number);
		
		if(account != null) {
			if(listAccounts.remove(account) == true)
				System.out.println("\nA Conta número (" + number + ") com o titular " + account.getHolderName() +" foi deletado com sucesso!");
		}else
			System.out.println("\nA Conta número ("+ number + ") não foi encontrada!");
		
	}

	@Override
	public void withdraw(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(int numberOrigin, int numberRecipient, float value) {
		// TODO Auto-generated method stub
		
	}
	
	public int newNumber() {
		return number++;
	}
	
	public Account searchInColletion(int number) {
		for(var account : listAccounts) {
			if(account.getNumber() == number)
				return  account;
		}
		
		return null;
	}

}
