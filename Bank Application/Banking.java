package bank;
import java.util.*;
public class Banking {
	static long accountNumber=13103;
	Scanner scan=new Scanner(System.in);
	static Banking bank=new Banking();
	static int transId=1;
	static ArrayList<TransDetails>transDetails=new ArrayList<TransDetails>();
	static HashMap<String,String>adminDetails=new HashMap<String,String>();
	static HashMap <Long,AccountOppning>accountdetails=new HashMap<Long,AccountOppning>();
	
	public void menu(){
		accountdetails.put(13100l,new AccountOppning("VIRAT",13100,"CURRENT","ECL90ERK",5000,"ACTIVE"));
		accountdetails.put(13101l,new AccountOppning("KOHLI",13101,"CURRENT","ERTP45CC",5000,"ACTIVE"));
		accountdetails.put(13102l,new AccountOppning("RAJA",13102,"SAVING","ERTP45JK",1000,"BLOCK"));
		adminDetails.put("raja", "7845");
		adminDetails.put("vel", "7856");
		System.out.println("---------WELCOME TO IPSR BANK-------\n\n1 Admin\n2 user\nselect your options");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			bank.adminMenu();
			break;
		case 2:
			bank.loginMenu();
			break;	
		}
	}
	public void adminMenu() {
		System.out.println("Select admin or user\n1 new Admin\n2 login\n3 Exit\nselect your options");
		int option=scan.nextInt();
		if(option==2) {
			System.out.println("Enter your name ..");
			String name=scan.next();
			System.out.println("Enter your passward ..");
			String password=scan.next();
			if(adminDetails.containsKey(name)){
				if(adminDetails.get(name).equals(password)) {
					bank.accountInfo();
				}else {
					System.out.println("invalid username or password");
					bank.adminMenu();
				}
			}

		}if(option==3) {
			bank.menu();}
		else {
			System.out.println("Enter your name");
			String name=scan.next();
			System.out.println("Enter your passward");
			String password=scan.next();
			adminDetails.put(name, password);
			bank.adminMenu();
		} 	
	}
	public void accountInfo() {
		System.out.println("ADMIN OPTIONS\n1 AccountDetails\n2 transalationDetails\n3 accountDelete\n4 accountBlock\n5 loanStatement\n6 Back to adminmenu\nselect your option");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			bank.accountdetail();
			break;
		case 2:
			bank.transalationDetails();
			break;
		case 3:
			bank.accountDelete();
			break;
		case 4:
			bank.accountBlock();
			break;   
		case 5:
			bank.loanStatement();
			break;
		case 6:
			bank.adminMenu();
		}

	}public void accountBlock() {
		System.out.println("Enter your Account number");
		long acNo=scan.nextLong();
		System.out.println("1 Account Block\n2 Account unBlock");
		int option=scan.nextInt();
		if(option==1) {
			accountdetails.get(acNo).setAccountStatus("BLOCK");
		}else {
			accountdetails.get(acNo).setAccountStatus("ACTIVE");
		}
		bank.accountInfo();
	}

	public void accountDelete() {
		System.out.println("Enter your account number");
		long acNo=scan.nextLong();
		if(accountdetails.remove(acNo)!=null) {
			System.out.println("account delete operations sucessfully");
		}
		bank.accountInfo();

	}public void loanStatement() {
		System.out.println("AcNo\t\tloan  type\t\tloan Amount\t\tIntrest\t\tduration");
		for(Loan i:Loan.loanDetails) {
			i.display();
		}
		bank.accountInfo();
	}
	public void transalationDetails() {
		for(TransDetails j:transDetails) {
			j.display();
		}
		bank.accountInfo();
	}
	public void loginMenu() {

		System.out.println("-----user Options------\n1 new Account\n2 deposite\n3 withdral\n4 balance enquary\n5 loan site\n6 Back to Menu\nselect your options");

		int option=scan.nextInt();
		switch(option) {
		case 1:
			bank.accountOppening();
			break;
		case 2:
			bank.deposite();
			break;
		case 3:
			bank.withdral();
			break;
		case 4:
			bank.balanceenqury();
			break;
		case 5:
			bank.loanSite();
			break;
		case 6:
			bank.menu();
		}	
	}
	public void accountOppening() {
		System.out.println("------Banking------\n\n\"Enter your name");
		String name=scan.next();
		System.out.println("Enter your pan number");
		String panNo=scan.next();
		
		System.out.println("select your account type\n1.current Account\n2.saving Account\n3 salery Acount\nselect your option");
		int option=scan.nextInt();
		String accountType="";
		double baseAmount=0;
		switch(option) {
		case 1:
			accountType="current";
			baseAmount=5000.00d;
			break ;
		case 2:
			accountType="saving";
			baseAmount=1000.00d;
		break;
		case 3:
			accountType="salery";
			baseAmount=0.0d;
		}
		accountdetails.put(accountNumber,new AccountOppning(name,accountNumber,accountType,panNo,baseAmount,"ACTIVE"));
		System.out.println("Account created sucessfully");
		accountNumber++;
		bank.loginMenu();

	}
	public void deposite() {
		System.out.println("---AMOUNT DEPOSITE----\nEnter the account number");
		long acNo=scan.nextLong();
		
		if(accountdetails.get(acNo).getAccountStatus().equals("ACTIVE")&&accountdetails.containsKey(acNo)) {
			System.out.println("Enter your amount");
			double amount=scan.nextDouble();
			accountdetails.get(acNo).setBalance(accountdetails.get(acNo).getBalance()+amount);
			transDetails.add(new TransDetails(transId,acNo,"DEPOSIT",amount));
			transId++;
		}
		else {
			System.out.println("YOUR ACCOUNT IS BLOCKED PLEASE CONTACt MANAGER");
		}
		
		bank.loginMenu();
	}
	public void withdral() {
		System.out.println("---AMOUNT WITHDRAL-----\nEnter the account number");
		long acNo=scan.nextLong();
		if(accountdetails.get(acNo).getAccountStatus().equals("ACTIVE")&&accountdetails.containsKey(acNo)) {
			System.out.println("Enter your amount");
			double amount=scan.nextDouble();
			if(accountdetails.get(acNo).getBalance()-amount>0) {
				accountdetails.get(acNo).setBalance(accountdetails.get(acNo).getBalance()-amount);
				transDetails.add(new TransDetails(transId,acNo,"WITHDRAL",amount));
				transId++;
			}
		}else {
			System.out.println("YOUR ACCOUNT IS BLOCKED PLEASE CONTACT MANAGER");
		}

		bank.loginMenu();
	}
	public void balanceenqury() {
		System.out.println("-----BALANCE ENQURY---\nEnter the account number");
		long acNo=scan.nextLong();
		if(accountdetails.get(acNo).getAccountStatus().equals("ACTIVE")&&accountdetails.containsKey(acNo)) {
		System.out.println("your balance "+accountdetails.get(acNo).getBalance());
		transDetails.add(new TransDetails(transId,acNo,"CHECKBALANCE",accountdetails.get(acNo).getBalance()));
		}else {
			System.out.println("YOUR ACCOUNT IS BLOCKED PLEASE CONTACT MANAGER");
		}
		bank.loginMenu();
	}public void loanSite() {
		System.out.println("----LOAN DETAILS-----\n1. PERSONAL LOAN\n2. HOME LOAN\n3 GOLDLOAN\n 4.VEHICALE_LONE\nselect your option");
		Loan loan=new Loan();
		int option=scan.nextInt();
		switch(option) {
		case 1:
			loan.personalLoan();
			break;
		case 2:
			loan.homeLoan();
			break;
		case 3:
			loan.goldLoan();
			break;
		case 4:
			loan.vehicaleLoan();
			break;
		default:
			bank.loanSite();
		}
		bank.loginMenu();
	}
	public void accountdetail() {
		System.out.println("----ACCOUNT  DETAILS------\nAcno\t\tname\t\tpan no\t\taccountType\tblanace\taccountStatus");
		for(Map.Entry<Long,AccountOppning>j:accountdetails.entrySet()) {
			System.out.print(j.getKey());
			j.getValue().display();  
		}
		bank.accountInfo();
	}
}