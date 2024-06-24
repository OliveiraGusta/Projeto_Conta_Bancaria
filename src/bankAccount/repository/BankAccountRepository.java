package bankAccount.repository;

import bankAccount.model.Account;

public interface BankAccountRepository {

	public void findByNumber(int numero);

	public void listAll();

	public void create(Account account);

	public void update(Account account);

	public void delete(int number);

	
	public void withdraw(int number, float value);

	public void deposit(int number, float value);

	public void transfer(int numberOrigin, int numberRecipient , float value);
	
}
