package bankAccount.model;

public class AccountSavings extends Account{

	private int birthday;
	
	public AccountSavings(int number, int agency, int type, String holder, float balance, int birthday) {
		super(number, agency, type, holder, balance);
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
