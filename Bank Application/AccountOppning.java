package bank;
public class AccountOppning {
    private String name;
    private long accountNumber;
    private String accountType;
    private String panCardNo;
    private double balance;
    private String accountStatus;
    public AccountOppning(String name, long accountNumber, String accountType, String panCardNo,double balance,String accountStatus) {
        this.name = name;
        this.accountNumber = accountNumber+1;
        this.accountType = accountType;
        this.panCardNo = panCardNo;
        this.balance=balance;
        this.accountStatus=accountStatus;
    }

    
	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPanCardNo() {
        return panCardNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setPanCardNo(String panCardNo) {
        this.panCardNo = panCardNo;
    }
    public void display() {
    	System.out.println("\t\t"+name+"\t\t"+panCardNo+"\t"+accountType+"\t\t"+balance+"\t\t"+accountStatus+"\n");
    }
}

