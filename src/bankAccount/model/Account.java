package bankAccount.model;

public abstract class  Account {
	private int number;
	private int agency;
	private int type;
	private String holderName;
	private float balance;

	public Account(int number, int agency, int type, String holderName, float balance) {
		this.number = number;
		this.agency = agency;
		this.type = type;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean withdraw(float value) {
		if (this.getBalance() < value) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		this.setBalance(this.getBalance() - value);
		return true;
	}

	public void deposit(float value) {
		this.setBalance(this.getBalance() + value);
	}

	public void viewAccountDetails() {
		String type = "";

		switch (this.type) {
		case 1:
			type = "Conta Corrente";
			break;
		case 2:
			type = "Conta Poupança";
			break;
		}

		System.out.printf("""
				\n
				%s - %d
				---------------------------------------------
				Saldo: R$%.2f
				Agência: %d
				Tipo da Conta: %s
				""", this.holderName, this.number, this.balance, this.agency, type);
	}
}
