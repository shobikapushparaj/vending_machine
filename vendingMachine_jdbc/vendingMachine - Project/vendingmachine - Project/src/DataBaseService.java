import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseService { //This contains multiple tables so Didn't create TableNameDAO class & Interface for specific Tables
	
	public static Connection dataBaseConnection; // is this public static ? private ? should be created in diff class
	
	static {
		JDBCUtil jdbcUtil = new JDBCUtil();
		dataBaseConnection = JDBCUtil.getConnection();
		
	}
	
//	JDBCUtil jdbcUtil = new JDBCUtil();
	private String DELETE_TABLE_QUERY = "DROP TABLE ";
	
	public DataBaseService() {
//		dataBaseConnection = JDBCUtil.getConnection();
	}
	
	public void execute(String query) {
    	try {
        	Statement statement = dataBaseConnection.createStatement();
        	statement.execute(query);
        	JDBCUtil.closeStatement(statement);
//        ----------------	dataBaseConnection.close();---------------------- // Close it in the end
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}

    }
	
	public void insertToTable(String insertQuery) {
    	try {
//    		PreparedStatement prep = dataBaseConnection.prepareStatement(insertQuery);
    		//prep.setFloat(1, 1.0);
        	Statement statement = dataBaseConnection.createStatement();
        	statement.executeUpdate(insertQuery);
        	JDBCUtil.closeStatement(statement);
//        ----------------	dataBaseConnection.close();---------------------- // Close it in the end
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    	}

    }


	public float retriveSingleRecord(String query) {
		ResultSet data = null;
		float record = 0F;
		try {
        	Statement statement = dataBaseConnection.createStatement();
        	data = statement.executeQuery(query);
        	data.next();
//        	System.out.println("OUT" + data.getFloat("amount"));
        	
        	record = data.getFloat(1);
        	JDBCUtil.closeStatement(statement);
    	}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return record;
	}
	
	public void updateRecord(String query) {
		try {
			Statement statement = dataBaseConnection.createStatement();
			statement.executeUpdate(query);
			JDBCUtil.closeStatement(statement);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet retriveTableOfData(String query) {
		ResultSet retrivedData = null;
		try {
			Statement statement = dataBaseConnection.createStatement();
			retrivedData = statement.executeQuery(query);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return retrivedData;
	}
	
	
	public void closeDataBaseConnection() {
		try {
			JDBCUtil.closeConnection(dataBaseConnection);
			dataBaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTable(String tableName) {
		
		try {
			Statement statement = dataBaseConnection.createStatement();
			statement.executeUpdate(DELETE_TABLE_QUERY+tableName);
			JDBCUtil.closeStatement(statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}