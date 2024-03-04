import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static final String DB_DRIVER =
			"com.mysql.cj.jdbc.Driver";
private static final String DB_URL =
		"jdbc:mysql://localhost:3306/vending_machine";
private static final String DB_USERNAME = "root";
private static final String DB_PASSWORD = "#2Shobi*";

public static Connection getConnection(){
	Connection conn = null;
	try{
		//Register the JDBC driver
		Class.forName(DB_DRIVER);

		//Open the connection
		conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

		if(conn != null){
		   System.out.println("Successfully connected.");
		}else{
		   System.out.println("Failed to connect.");
		}
	}catch(Exception e){
		e.printStackTrace();;
	}
	return conn;
}

public static void closeConnection(Connection conn) {
	try {
		conn.close();
	} catch (SQLException e) {
		System.out.println("Data base connection is not closed");
		e.printStackTrace();
	}
}

public static void closeStatement(Statement st) {
	try {
		st.close();
	} catch (SQLException e) {
		System.out.println("Data base connection is not closed");
		e.printStackTrace();
	}
}

}
