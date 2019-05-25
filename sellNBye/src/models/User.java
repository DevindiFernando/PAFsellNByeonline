package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class User {
	
public String reg(String name, String email, String password, String address) {
		
		Connection con = null;
		java.sql.Statement statement = null;
		ResultSet resultSet = null;
		
		String nameDB = "";
		String passwordDB = "";
		String emailDB = "";
		String addressDB = "";
		
		try {
			con = DBController.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select nameUsers,passUsers,email,address");
		
			while(resultSet.next()) {
				nameDB = resultSet.getString("nameUsers");
				passwordDB = resultSet.getString("passUsers");
				emailDB = resultSet.getString("emailUsers");
				addressDB = resultSet.getString("addressUsers");
				
				if(name.equals(nameDB) && password.equals(passwordDB)&& email.equals(emailDB) && address.equals(addressDB) ) {
					return"SUCCESS";
				}
			}
		
		
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return "Invalid user credentials";
		
		}


}
