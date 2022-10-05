package invoice;
import java.sql.ResultSet;
import java.sql.Statement;
public class Billing {
	public  void billing(String product_name,int product_count) {
		System.out.println("Billing Secssion");
		try {
			DatabaseConnection connection=new DatabaseConnection();
			Statement st=connection.dbconnection();
			System.out.println("Enter the stock details\n1 ProductName");
			ResultSet rt=st.executeQuery("select * from Stock where pname='"+product_name+"'");
			while(rt.next()) {
				int r=rt.getInt(4);
				System.out.println("----Bill----\nproduct name\t\t"+product_name+"\nprodouc_count\t\t"+product_count+"\nTotalAmount\t\t"+r*product_count+"\n");	
			}		
		}catch(Exception e) {
	      e.printStackTrace();
		}	
		
		
	}
}
