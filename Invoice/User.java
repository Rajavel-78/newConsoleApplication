package invoice;
import java.sql.*;
import java.util.Scanner;
public class User{
	static Booking book=new Booking();
	static User user=new User();
	Scanner scan=new Scanner(System.in);
	public  void usermenu() {
		System.out.println("TO ORDER\n1 order the iteams\n2 Back to Menu");
		int option=scan.nextInt();
		switch(option) {
		case 1:
			user.order();
			break;
		case 2:
			book.operation();
		}
	}public void order() {
		System.out.println("==================\n---ORDER MENU----\n List");
		try {
			DatabaseConnection connection=new DatabaseConnection();
			Statement st=connection.dbconnection();
			System.out.println("----Products details----");
			ResultSet result=st.executeQuery("select * from Stock where quandity>0");
			System.out.println("PId\tpName\t\tquty\trate");
			while(result.next()) {
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t\t"+result.getInt(3)+"\t"+result.getInt(4));
			}
			System.out.println("1 Order the product");
			String productName=scan.next();
			System.out.println("2 product count");
			int productCount=scan.nextInt();
			result=st.executeQuery("select * from Stock");
			boolean isValied=true;
			while(result.next()){
				if(productName.equals(result.getString(2))&&productCount<result.getInt(3)){
					int uptate=st.executeUpdate("update Stock set quandity="+(result.getInt(3)-productCount)+" where Pname='"+productName+"'");
					isValied=false;
					Billing bill=new Billing();
					bill.billing(productName,productCount);
					break;
				}
			}if(isValied){	
				System.out.println("onely "+result.getInt(3)+" stock");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}user.usermenu();
	}
	
}