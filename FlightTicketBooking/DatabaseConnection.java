package FlightBookingApplication;

import java.sql.*;

public class DatabaseConnection {
	private static Statement statement;
	static String a="s";
	private DatabaseConnection(){
	}
	public static Statement dbConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Flight","rajavel","Password123#@!");
			statement=connection.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return statement;
	}
	public static Statement getInstance() {
		if(statement==null) {
			DatabaseConnection connection=new DatabaseConnection();
			DatabaseConnection connection1=new DatabaseConnection();
			DatabaseConnection connection2=new DatabaseConnection();
			connection1.a="a";
			connection2.a="b";
			System.out.println(a);
			
		return connection.dbConnection();
		}
       	
		return statement;
	}
}
