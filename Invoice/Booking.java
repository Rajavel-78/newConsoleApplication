package invoice;
import java.util.Scanner;
public class Booking{
	Scanner scan=new Scanner(System.in);
	public static void main(String[] args) {
		Booking book=new Booking();
		book.operation();
	}
	public void operation() {
		System.out.println("select the option\n1 Admin\n2 User");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			Admin clint=new Admin();
			clint.adminOperation();
			break;
		case 2:
			User user=new User();
			user.usermenu();
			break;
		}
	}
}
