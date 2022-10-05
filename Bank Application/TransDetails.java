package bank;

public class TransDetails {
	private int transId;
	private long accountNo;
	private String amountType;
	private double amount;
	
	public TransDetails(int transId, long accountNo, String amountType, double amount) {
		this.transId = transId;
		this.accountNo = accountNo;
		this.amountType = amountType;
		this.amount = amount;
	}
   public void display() {
	   System.out.println("tranid\tacNo\tType\tamount");
	   System.out.println(transId+"\t"+accountNo+"\t"+amountType+"\t"+amount);
   }

 
}
