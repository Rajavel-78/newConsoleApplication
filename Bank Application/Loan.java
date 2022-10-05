package bank;

import java.util.*;

public class Loan {
    Scanner scan=new Scanner(System.in);
	static ArrayList<Loan>loanDetails=new ArrayList<Loan>();
	static Banking bank=new Banking();
	private String loanType;
	private static int loanId;
	private double loanAmount;
	private double baseIntrest=4.3d;
	private int duration;
	private long accountNumber;
	public Loan( Long	accountNumber,	String loanType, double loanAmount, double baseIntrest, int duration){
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.baseIntrest = baseIntrest;
		this.duration = duration;
		this.accountNumber=accountNumber;
	}public Loan(){
	
	}
	
	public void personalLoan() {
		System.out.println("Enter your Account number");
		long acNo=scan.nextLong();
		if(Banking.accountdetails.containsKey(acNo)) {
		Banking.accountdetails.get(acNo).setBalance(Banking.accountdetails.get(acNo).getBalance()+100000);
		loanDetails.add(new Loan(acNo,"PersonalLOan",100000.00d,4.3f,3));
		System.out.println("loan amount created sucessfully");
		}else {
			System.out.println("invalid account number");
		}
		bank.loanSite();
	}
	public void goldLoan() {
		double goldRate=30782.22d;
		System.out.println("Enter your Account number");
		long acNo=scan.nextLong();
		if(Banking.accountdetails.containsKey(acNo)) {
		System.out.println("gold Weight kilogram");
	    int goldKg=scan.nextInt();
	    double totalAmount=goldKg*goldRate;
		Banking.accountdetails.get(acNo).setBalance(Banking.accountdetails.get(acNo).getBalance()+totalAmount);
		loanDetails.add(new Loan(acNo,"GOLD LOan",totalAmount,7.3f,12));
		System.out.println("loan amount created sucessfully");
		}
		else {
			System.out.println("invalid account number");
		}
	}
	public void vehicaleLoan() {
		System.out.println("Enter your Account number");
		long acNo=scan.nextLong();
		if(Banking.accountdetails.containsKey(acNo)) {
		Banking.accountdetails.get(acNo).setBalance(Banking.accountdetails.get(acNo).getBalance()+100000);
		loanDetails.add(new Loan(acNo,"vehicalLOan",100000.00d,4.3f,3));
		System.out.println("loan amount created sucessfully");
		}
		else {
			System.out.println("invalid account number");
		}
		bank.loanSite();
	}
	public void homeLoan() {
		System.out.println("Enter your Account number");
		long acNo=scan.nextLong();
		Banking.accountdetails.get(acNo).setBalance(Banking.accountdetails.get(acNo).getBalance()+100000);
		loanDetails.add(new Loan(acNo,"HOME LOan",100000.00d,4.3f,3));
		System.out.println("loan amount created sucessfully");
		
	}

	public void display() {
		System.out.println(accountNumber+"\t\t"+loanType+"\t\t"+loanAmount+"\t\t"+baseIntrest+"\t\t"+duration);
		
	}
}
