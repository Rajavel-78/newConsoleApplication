package FlightBookingApplication;

public class Main {

	public static void main(String[] args) {
		Main main=new Main();
		main.operation();
	}
	public void operation() {
		System.out.println("Welcome to INDIAN AIRLINES");
		Booking book=new Booking();
		book.menu();
	}

}
