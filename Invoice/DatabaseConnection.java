package invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    public Statement dbconnection(){
    	Statement statement=null;
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Store","rajavel","Password123#@!");
    		statement=connection.createStatement();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return statement;
    }
}
