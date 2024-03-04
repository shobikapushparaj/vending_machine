
public class ContainerDAO { // Should be an interface and Implementation
	
	private DataBaseService dataBaseService = new DataBaseService();
    private String retriveContainerQuery = "SELECT amount FROM container_status WHERE container_name='%s'";
    private String updateContainerQuery = "UPDATE container_status SET amount=%s WHERE container_name ='%s'";
    private String tableName = "container_status";
    
    public ContainerDAO() {
    }
    
    public void createContainerTable() {
		  
    	System.out.println("Step #1 - Create Container Table");
		   String ContainerQuery =
				              
				    "CREATE TABLE container_status("
					+ "container_name varchar(20),"
					+ "amount float)";    
		   dataBaseService.execute(ContainerQuery);
	   }
    
    public void addValuesToContainerTable(Float tea_container, Float coffee_container, Float sugar_container, Float water_container, Float milk_container) {
    	
    	String teaContainer = "INSERT INTO container_status(container_name,amount) "
    			+ "VALUES('tea'," 
    			+ tea_container + ")";
    	dataBaseService.insertToTable(teaContainer);
    	
    	String coffeeContainer = "INSERT INTO container_status(container_name,amount) "
    			+ "VALUES('coffee'," 
    			+ coffee_container + ")";
    	dataBaseService.insertToTable(coffeeContainer);
    	
    	String sugarContainer = "INSERT INTO container_status(container_name,amount) "
    			+ "VALUES('sugar'," 
    			+ sugar_container + ")";
    	dataBaseService.insertToTable(sugarContainer);
    	
    	String waterContainer = "INSERT INTO container_status(container_name,amount) "
    			+ "VALUES('water'," 
    			+ water_container + ")";
    	dataBaseService.insertToTable(waterContainer);
    	
    	String milkContainer = "INSERT INTO container_status(container_name,amount) "
    			+ "VALUES('milk'," 
    			+ milk_container + ")";
    	dataBaseService.insertToTable(milkContainer);
    }
    
    public float retriveSingleContainerValue(String containerType) {
    	System.out.println(String.format(retriveContainerQuery, containerType));
    	 return dataBaseService.retriveSingleRecord(String.format(retriveContainerQuery, containerType)); // should I send this as float instead of string in a query ?
    	
    }
    
    public void updateIndividualContainer(String containerType, Float value) {
    	String query = String.format(updateContainerQuery, value, containerType);
    	dataBaseService.updateRecord(query);
    }
    
    public void deleteContainerTable() {
    	dataBaseService.deleteTable(tableName);
    }

}
