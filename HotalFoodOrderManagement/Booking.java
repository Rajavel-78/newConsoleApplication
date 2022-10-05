package hotalfoodordermanagement;

import java.util.*;
import java.util.Map.Entry;

public class Booking {
	static int tableid=11;
    Scanner scan=new Scanner(System.in);
   static Booking book=new Booking();
   static HashMap<Integer,Table>tableDetails=new HashMap<Integer,Table>();
   static HashMap<String,Double>foodDetails=new HashMap<String,Double>();
   static HashMap<Integer,Double>billDetails=new HashMap<Integer,Double>();
   static HashMap<Integer,ArrayList>orderDetails=new HashMap<Integer,ArrayList>();
	public  void storeData(){
        foodDetails.put("dosa", 30.0d);
        foodDetails.put("vada", 5.0d);
		tableDetails.put(1,new Table(10,"Avilable"));
		tableDetails.put(2,new Table(10,"Avilable"));
		tableDetails.put(3,new Table(10,"Avilable"));
		tableDetails.put(4,new Table(10,"Avilable"));
		tableDetails.put(5,new Table(10,"Avilable"));
        book.options();
	}public void options() {
		System.out.println("Select Option\n1 Admin\n2 User\n3 Exit");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			book.bookingOperation();
		break;	
		case 2:
			book.bookingUser();
		break;
		case 3:
			book.exit();	
		}
		
	}public void exit() {
		System.out.println("HOTAL IS CLOSED");
	}public void bookingUser() {
		System.out.println("Select your option\n1 OrderFood\n2 cancalFood\n3 orderTable\4 cancalTables");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			book.orderTables();
		break;
		case 2:
		  book.cancalFood();
		break;
		case 3:
		 book.bookingTable();
		 break;
		}
	}
	public void bookingOperation(){
		System.out.println("-----OPTIONS-----\n1 AVILABLE TABLE\n2 BOOKING TABLE\n3 BILLING\n4 management\n5 Back to Menu\nSELECT YOUR OPTION");
		int option=scan.nextInt();
		switch(option){
		case 1:
			book.avilableTable();
		break;
		case 2:
			book.bookingTable();
		break;	
		case 3:
			book.bill();
		break;
		case 4:
			book.management();
		break;
		case 5:
			book.options();
			
		  }
	  }
	private void management() {
		System.out.println("MANAGEMENT SITE\n1 Tables Mantains\n2 Add Food");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			System.out.println("1 Add Table\n2 Remove Table\nSelect your option");
			int select=scan.nextInt();
			if(select==1) {
				tableDetails.put(tableid, new Table(10,"Avilable"));
			}else {
				System.out.println("Enter the table no");
				int tableNo=scan.nextInt();
				tableDetails.remove(tableNo);
			}
		break;
		case 2:
			System.out.println("Enter the food name");
			String foodName= scan.next();
			System.out.println("Enter the Rate");
			double rate=scan.nextDouble();
			foodDetails.put(foodName, rate);
		break;	
		}book.bookingOperation();
	}
	private void bill() {
		System.out.println("Enter the table number");
		int tableNo=scan.nextInt();
		double total=0;
		int no=1;
		System.out.println("--------------------------------\n--------ISRT HOTAL AC VEG--------\n---------List-------\n");
		System.out.println("s.no\tname\tqua\tu.cost\tamount");
		try {
		ArrayList<String>arr=new ArrayList<String>(orderDetails.get(tableNo));
		for(String i:arr) {
			String []arr1=i.split(" ");
			System.out.print(no+"\t"+arr1[0]+"\t"+arr1[1]+"\t"+foodDetails.get(arr1[0])+"\t"+foodDetails.get(arr1[0])*Double.parseDouble(arr1[1])+"\n");
			no++;
			total+=foodDetails.get(arr1[0])*Double.parseDouble(arr1[1]);
		}System.out.println("\t\tTotal\t"+total);
		tableDetails.get(tableNo).setStatus("Avilable");
		}catch(Exception e) {
			System.out.println("no iteams");
		}
		book.bookingOperation();
	}
	public void avilableTable() {
		System.out.println("------AVILABLE TABLE--------");
		for(Entry<Integer, Table> l:tableDetails.entrySet()) {
			System.out.print(l.getKey());
			l.getValue().display();
		}
		book.bookingOperation();
	}public void cancalFood() {
		System.out.println("-----Food Details----\ncansal your food");
		System.out.println("Table Number");
		int tableNo=scan.nextInt();
		orderDetails.remove(tableNo);
		book.bookingOperation();
	}
	public void orderTables() {
		System.out.println("-----Food Details----\nselect your food");
		for(Entry<String,Double>j:foodDetails.entrySet()) {
			System.out.println(j.getKey()+"  "+j.getValue());
		}
		System.out.println("Table Number");
		int tableNo=scan.nextInt();
         ArrayList<String>arr=new ArrayList<String>();
		boolean isValid=true;
         while(isValid) {
        	 System.out.println("select the food");
             String food=scan.next();
             System.out.println("select the count");
              food+=" "+scan.next();
              arr.add(food);
             System.out.println("continoue purchase\n1 yes\n2 no");
             int option=scan.nextInt();
             if(1==option) {
            	 isValid=true;
            	 food="";
             }else {
            	 isValid=false;
             }
         }
         orderDetails.put(tableNo,arr);
		book.bookingOperation();
	}
	private void bookingTable() {
		System.out.println("Avilable Tables");
		System.out.println("------AVILABLE TABLE--------");
		for(Entry<Integer, Table> l:tableDetails.entrySet()) {
			System.out.print(l.getKey());
			l.getValue().display();
		}
		System.out.println("select your table");
		int option=scan.nextInt();
		if(tableDetails.get(option).getStatus().equals("Avilable")) {
		tableDetails.get(option).setStatus("Booked");
		}else {
			System.out.println("table is Already booked chose another table");
			book.bookingTable();
		}
		book.bookingOperation();
	}	
}