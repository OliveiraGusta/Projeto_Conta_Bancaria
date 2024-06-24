package bankAccount.model;

public class AccountSavings extends Account{

	private int birthday;
	
	public AccountSavings(int number, int agency, int type, String holderName, float balance, int birthday) {
		super(number, agency, type, holderName, balance);
		this.birthday = birthday;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public void viewAccountDetails() {
		super.viewAccountDetails();
		System.out.println("Aniversario da conta: " + this.birthday);
	}
	

}
