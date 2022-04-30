package models;

public class CuentaBanco {
	private String clientName;
	private int accountNum;
	private double accountMoney;

	public CuentaBanco(String clientName, int accountNum, double accountMoney) {
		super();
		this.clientName = clientName;
		this.accountNum = accountNum;
		this.accountMoney = accountMoney;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(double accountMoney) {
		this.accountMoney = accountMoney;
	}
	
	public void addMoneyToAccount(double money) {
		this.setAccountMoney(this.getAccountMoney() + money);
	}
	
	public boolean transferMoney(double money, CuentaBanco other) {
		if(money <= this.getAccountMoney()) {
			this.setAccountMoney(this.getAccountMoney() - money);
			other.addMoneyToAccount(money);
			return true;
		}
		return false;
	}
	
	public boolean reintegramiento(double money) {
		if(money <= this.getAccountMoney()) {
			this.setAccountMoney(this.getAccountMoney() - money);
			return true;
		}
		return false;
	}

}
