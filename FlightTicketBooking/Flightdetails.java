package FlightBookingApplication;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Flightdetails{
	static Flightdetails fd=new Flightdetails();
	static Scanner scan=new Scanner(System.in);
	public void admin(){
		System.out.println("\n1 addFlight\n2 removeFlight\n3 flightDetails\n4 Back to menu\nSelect your choice");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			fd.addFlight();
			break;	
		case 2:
			fd.removeFlight();
			break;
		case 3:
			fd.flightDetails();
		break;
		case 4:
			Booking book=new Booking();
			book.menu();
		}
	}
	private void addFlight() {
		System.out.println();
		try {
			Statement statement=DatabaseConnection.getInstance();	
			System.out.println("Enter the Flight Details\nEnter the Flight name");
			String fName=scan.next();
			System.out.println("Enter the bording Point");
			String bordingPoint=scan.next();
			String s=scan.next();
			System.out.println("Enter the landingPoint");
			String landingPoint=scan.next();
			System.out.println("Enter the sets");
			int sets=scan.nextInt();
			int rs=statement.executeUpdate("insert into FlightDetails(Fname,point,end,Eset,seting)values('"+fName+"','"+bordingPoint+"','"+landingPoint+"',"+sets+","+sets+")");
			System.out.println("Flight Details\nno\tFname\tfrom\tTo\tsets");
		}
		catch(Exception e) {

		}
		fd.admin();
	}private void removeFlight() {
		try {
			Statement st=DatabaseConnection.getInstance();
			System.out.println("Enter the Flight no");
			int sets=scan.nextInt();
			ResultSet rs=st.executeQuery("select * from FlightDetails");
			while(rs.next()) {
				if(rs.getInt(1)==sets){
					int reslt = st.executeUpdate("delete from FlightDetails where Fno = "+sets+"");
					break;
				}
			}
		}
		catch(Exception e) {
		}fd.admin();
	}
	public void flightDetails() {
		try {
			Statement st=DatabaseConnection.getInstance();	
			ResultSet rs=st.executeQuery("select * from FlightDetails");
			System.out.println("Flight Details\nno\tFname\tfrom\tTo\tsets");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
		}
		catch(Exception e) {
		}System.out.println("\n1 Back to menu\n2 Booking Ticket");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			fd.admin();
		break;
		case 2:
			Booking book=new Booking();
			book.bookingTicket();
		break;	
		}
		fd.admin();
	}
}