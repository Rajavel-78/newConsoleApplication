
package FlightBookingApplication;
import java.util.Scanner;
class CheckAdmin {
	Scanner scan=new Scanner(System.in);
	public boolean checkAdmin() {
		System.out.println("Enter the User name");
		String name=scan.next();
		System.out.println("Enter the Password");
		String password=scan.next();
		boolean check=name.equals("Admin")&&password.equals("raja");
		return check;
	}
	void adminMenu() {
		Booking book=new Booking();
		CheckAdmin check=new CheckAdmin();
		boolean isValied=check.checkAdmin();
		if(isValied){
			System.out.println("========================\n=========================\n");
			System.out.println("Select the Option \n1 Passanger Details\n2 Ticket Details\n3 Flight Details\n4 back to menu\nselect your options/n");
			int option=scan.nextInt();
			switch(option) {
			case 1:
				book.passangerDetails();
				break;
			case 2:
				book.ticketDetails();
				break;
			case 3:
				Flightdetails flight_ticket=new Flightdetails();
				flight_ticket.admin();
				break;	
			case 4:
				book.menu();
			}
		}
		else {
			System.out.println("Invlied user name and password \n------please try again latter");
			CheckAdmin chek=new CheckAdmin();
			check.adminMenu();
		}
	}
}	

