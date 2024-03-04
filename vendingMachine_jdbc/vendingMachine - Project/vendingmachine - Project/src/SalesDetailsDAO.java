import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesDetailsDAO {
	
	private DataBaseService dataBaseService = new DataBaseService();
    private List<Order> totalSalesList = new ArrayList();
    private String tableName = "sales_details";

	 public void createSalesDetailsTable() { 

		 String salesDetailQuery = 
				      
				      "CREATE TABLE sales_details("
					+ "customer_name VARCHAR(50) NOT NULL,"
					+ "date VARCHAR(100),"
					+ "product VARCHAR(20),"
					+ "order_id long NOT NULL,"
					+ "quantity int,"
					+ "amount float,"
					+ "mobile_number long"
					+ ")";
		   
		   System.out.println(salesDetailQuery);
		   
		   dataBaseService.execute(salesDetailQuery);
		   System.out.println("Sales Details Table is created successfully!");
	   }
	 
	 public void InsertInToSalesDetailsTable(String productName,Integer productId, Float amount, Integer quantity, String customerName, Long customerMobileNo, String date,Long orderId) {
		 String query = "INSERT INTO sales_details(customer_name,date,product,order_id,quantity,amount,mobile_number) "
				        + "VALUES('"+ customerName + "'"
				        + ",'" + date + "'"
				        + ",'" + productName + "'" 
				        + "," + orderId 
				        + "," + quantity 
				        + "," + amount 
				        + "," + customerMobileNo + ")";
		 System.out.println(query);
		 
		 dataBaseService.insertToTable(query); 
	 }
	 
	 public List<Order> retriveSalesDetails() {
		 ResultSet retrivedData;
		 String query = "SELECT * FROM sales_details";
		 retrivedData = dataBaseService.retriveTableOfData(query);
		

		 try {
			while(retrivedData.next()) {
				 Order order = new Order();
				 order.setAmount(retrivedData.getFloat("amount"));
				 order.setCustomerMobileNo(retrivedData.getLong("mobile_number"));
				 order.setCustomerName(retrivedData.getString("customer_name"));
				 order.setDate(retrivedData.getString("date"));
				 order.setOrderId(retrivedData.getLong("order_id"));
				 order.setProductName(retrivedData.getString("product"));
				 order.setQuantity(retrivedData.getInt("quantity"));
								 
				 totalSalesList.add(order);
			 }
			} catch (SQLException e) {
			e.printStackTrace();
}
		 
		 return totalSalesList;
	 }
	 
	  public void deleteSalesDetailsTable() {
	    	dataBaseService.deleteTable(tableName);
	    }
	   
}