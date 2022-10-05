package FlightBookingApplication;
import java.sql.*;
import java.util.*;

public class Booking {
	static Scanner scan=new Scanner(System.in);
	static Booking book=new Booking();
	static CheckAdmin check=new CheckAdmin();
	static Flightdetails flight_ticket=new Flightdetails();
	public void menu() {
		System.out.println("Select your option user or Admin\n1 Admin\n2 User");
		int option=scan.nextInt();
		switch(option){
		case 1:
			check.adminMenu();
			break;
		case 2:
			book.usermenu();
		}
	}
	public void ticketDetails() {
		System.out.println("Ticket Details");
		try {
			
			Statement statement=DatabaseConnection.getInstance();
			ResultSet res=statement.executeQuery("select * from Ticket");
			System.out.println("p.Id\tp.name\tFlight Name\tp.bordingPoint\tp.landing point\tE");
			while(res.next()) {
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4)+"\t"+res.getString(5)+"\t"+res.getString(6));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void usermenu(){
		System.out.println("----WELCOME TO IRST Airline*----\n1 ticket Booking\n2 ticket cancel\n3 back to menu");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			book.bookingTicket();
			break;
		case 2:
			book.cancelTisket();
			break;
		case 3:
			book.menu();
		}
		book.operation();
	}

	private void cancelTisket() {


	}
	public void operation(){
		System.out.println("Select the Option \n1 FlightDetails\n2 \n3 back to menu\nselect your options");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			flight_ticket.flightDetails();
			break;
		case 2:
			book.bookingTicket();
			break;
		case 3:
			book.menu();
		}
	}

	public void bookingTicket() {
		try {
			Statement st=DatabaseConnection.getInstance();	
			ResultSet result=st.executeQuery("select * from FlightDetails");
			System.out.println("Flight Details\nno\tFname\tfrom\tTo\tsets");
			while(result.next()) {
				System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5));
			}
			result.close();
			Statement statement=DatabaseConnection.getInstance();
			boolean isValid=true;
			while(isValid) {
				System.out.println("--------Welcome To IPRS AirLine\n------\nPassanger name");
				String pName=scan.next();
				System.out.println("Select your bording point");
				String bordingPoint=scan.next();
				System.out.println("Select your end poind");
				String landingPoint=scan.next();

				ResultSet rset=statement.executeQuery("select * from FlightDetails");
				while(rset.next()) {
					System.out.println(rset.getString(3));
					if(rset.getString(3).equals(bordingPoint)){
						System.out.println("Select your flight");
						String fName=scan.next();
						int Trate=2000;
						System.out.println("Enter the mailId");
						String mailId=scan.next();
						int rs=statement.executeUpdate("insert into Ticket(Pname,Fname,point,end,rate) values('"+pName+"','"+fName+"','"+bordingPoint+"','"+landingPoint+"',"+Trate+")");
						rs=statement.executeUpdate("insert into PassangerInfo(Pname,mailId,bordingPoint,landingPoint) values('"+pName+"','"+mailId+"','"+bordingPoint+"','"+landingPoint+"')");
						System.out.println("--------IRATC   ------------\npassanger Name: "+pName+"\nFlight Name: "+fName+"\n bording point  "+bordingPoint+"\n"+landingPoint);
						System.out.println("To you continue\n1 yes\n2 no");
						int option=scan.nextInt();
						switch(option) {
						case 1:
							break;
						case 2:
							isValid=false;
						}
					}else {
						System.out.println("Flight not Avilable");
						break;
					}
				}
			}
		}
		catch(Exception e) {
		}
	}public void passangerDetails() {
		try {
			Statement statement=DatabaseConnection.getInstance();	
			ResultSet rs=statement.executeQuery("select * from PassangerInfo");
			System.out.println("Passanger Info\nP.Id\tP.name\tmailId\tbordingPoint\tlandingPoint");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
			}
		}
		catch(Exception e) {
		}
		book.operation();
	}
}