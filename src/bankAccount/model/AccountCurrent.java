package bankAccount.model;

public class AccountCurrent extends Account {
	private float creditLimit;

	public AccountCurrent(int number, int agency, int type, String holderName, float balance, float creditLimit) {
		super(number, agency, type, holderName, balance);
		this.creditLimit = creditLimit;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float limit) {
		this.creditLimit = limit;
	}

	
	@Override
	public boolean withdraw(float valor) { 
		
		if(this.getBalance() + this.getCreditLimit() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		
		this.setBalance(this.getBalance() - valor);
		return true;
		
	}
	
    @Override
	public void viewAccountDetails() {
		super.viewAccountDetails();
		System.out.println("Limite de Crédito: " + this.creditLimit);
	}
	
}
