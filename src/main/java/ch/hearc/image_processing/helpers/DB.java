package ch.hearc.image_processing.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class DB {
	private DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String schemaName = "gustavedebeaumon_beaumont";
			String host = "localhost";
			String port = "3306";
			String username = "root";
			String password = "root";
			String connection = String.format("jdbc:mysql://%s:%s/%s", host, port, schemaName);
			
			con = DriverManager.getConnection(
					connection,
					username,
					password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws SQLException {
		Statement stmt = con.createStatement();
		return stmt.executeQuery(query);
	}
	
	private Connection con;
	
	public static DB instance = null;
	public static DB getInstance() {
		if (instance == null)
			instance = new DB();
		return instance;
	}
}
