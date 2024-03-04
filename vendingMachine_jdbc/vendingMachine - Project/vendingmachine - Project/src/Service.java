import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Service {

    Repository repo = Repository.getRepository();
    Container cont = new Container();
    ContainerDAO containerDao = new ContainerDAO();
    public DataBaseService databaseService = new DataBaseService();
    public Order order = new Order(); // To create Table
    SalesDetailsDAO salesDetailsDAO = new SalesDetailsDAO(); 
    private Integer counter =0;

    
 
    private int choice;
    Scanner in = new Scanner(System.in);
    
    public void createTables() {
    	salesDetailsDAO.createSalesDetailsTable();
    	containerDao.createContainerTable();
    	cont.initiateContainer();
    }
    

    public void showMenu(){
        while(true){
            printMenu();
            switch (choice) {
                case 1 -> onMakeBeanCoffee();
                case 2 -> onMakePremixTea();
                case 3 -> onMakeFreshMilkCoffee();
                case 4 -> onMakeEspresso();
                case 5 -> onRefillContainer();
                case 6 -> onCheckTotalSale();
                case 7 -> onContainerStatus();
                case 0 -> {
                    System.out.println("Thank You For Using Our Service. ");
                    containerDao.deleteContainerTable();
                    salesDetailsDAO.deleteSalesDetailsTable();
                    databaseService.closeDataBaseConnection();
                    System.exit(0);
                }
            }
        }
    }
    /**
     * This method Prints a Menu
     */
    public void printMenu(){
        System.out.println("-------Menu------");
        System.out.println("1.Make Bean Coffee");
        System.out.println("2.Make Premix Tea");
        System.out.println("3.Make Fresh Milk Coffee");
        System.out.println("4.Make Espresso");
        System.out.println("5.Refill Container ");
        System.out.println("6.Check Total Sale ");
        System.out.println("7.Container Status ");
        System.out.println("0.Exit");
        System.out.println("----------------- ");
        System.out.print("Enter Your Choice--");
        choice=in.nextInt();
    }

    /**
     * This Method will Make BeanCoffee for the User.
     */
    public void onMakeBeanCoffee(){
        in.nextLine();
        System.out.println("Welcome! Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 1;
        String productName = "Bean Coffee";
        System.out.println("Nice to meet you " + customerName +"!, Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Coffee Do You Want to Order");
        int coffeeQuantity = in.nextInt();
        Float amount = coffeeQuantity*15.0F;
        

        if(cont.getCoffee_container()>(5*coffeeQuantity) && cont.getWater_container()>(23*coffeeQuantity) &&
                cont.getMilk_container()>(88*coffeeQuantity) && cont.getSugar_container()>(17*coffeeQuantity)){ //Aarthi -  isn't it >= ? getCoffeeContainer()>= ?

            Order order = new Order(productName,productId,amount,coffeeQuantity,customerName,customerMobile);
            order.recordOrderData(order);
            System.out.println("Order values are recorded to Sales Table");
            
            System.out.println("Taking Your Order Please Wait for a while");

            System.out.println("Your Order is Ready. Please pay Rs."+amount+".");

            cont.setCoffee_container(cont.getCoffee_container() - coffeeQuantity*5);
            cont.setWater_container(cont.getWater_container() - coffeeQuantity*23);
            cont.setMilk_container(cont.getMilk_container() - coffeeQuantity*88);
            cont.setSugar_container(cont.getSugar_container() - coffeeQuantity*17);

        }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Make Premix Tea for the User.
     */
    private void onMakePremixTea() {
        in.nextLine();

        System.out.println("Welcome, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 2;
        String productName = "Premix Tea";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Tea Do You Want to Order");
        int teaQuantity = in.nextInt();
        Float amount = teaQuantity*10.0F;

        if(cont.getTea_container()>(6*teaQuantity) && cont.getWater_container()>(65*teaQuantity) &&
                cont.getMilk_container()>(44*teaQuantity) && cont.getSugar_container()>(17*teaQuantity)){

        	Order order = new Order(productName,productId,amount,teaQuantity,customerName,customerMobile);
            order.recordOrderData(order);
            System.out.println("Order values are recorded to Sales Table");
            
            System.out.println("Taking Your Order Please Wait for a while");

            System.out.println("Your Order is Ready. Please pay Rs."+amount+".");

            cont.setCoffee_container(cont.getCoffee_container() - 0);
            cont.setWater_container(cont.getWater_container() - teaQuantity*65);
            cont.setMilk_container(cont.getMilk_container() - teaQuantity*44);
            cont.setSugar_container(cont.getSugar_container() - teaQuantity*17);
            cont.setTea_container(cont.getTea_container() - teaQuantity*6);

        }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Fresh milk Coffee for the User.
     **/
    private void onMakeFreshMilkCoffee() {
        in.nextLine();

        System.out.println("Welcome, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 3;
        String productName = "Fresh Milk Coffee";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Fresh Milk Coffee Do You Want to Order");
        int freshMilkCoffeeQuantity = in.nextInt();
        Float amount = freshMilkCoffeeQuantity*10.0F;

        if(cont.getCoffee_container()>=(3*freshMilkCoffeeQuantity) && cont.getWater_container()>=(42*freshMilkCoffeeQuantity) &&
                cont.getMilk_container()>=(110*freshMilkCoffeeQuantity) && cont.getSugar_container()>=(17*freshMilkCoffeeQuantity)){


        	Order order = new Order(productName,productId,amount,freshMilkCoffeeQuantity,customerName,customerMobile);
            order.recordOrderData(order);
            System.out.println("Order values are recorded to Sales Table");
            
            System.out.println("Taking Your Order Please Wait for a while");

            System.out.println("Your Order is Ready. Please pay Rs."+amount+".");

            cont.setCoffee_container(cont.getCoffee_container() - freshMilkCoffeeQuantity*3);
            cont.setWater_container(cont.getWater_container() - freshMilkCoffeeQuantity*42);
            cont.setMilk_container(cont.getMilk_container() - freshMilkCoffeeQuantity*110);
            cont.setSugar_container(cont.getSugar_container() - freshMilkCoffeeQuantity*17);
            cont.setTea_container(cont.getTea_container() - 0);


        }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Make Espresso for the User
     */
    private void onMakeEspresso() {
        in.nextLine();

        System.out.println("Welcome, Please Enter Your Name");
        String customerName = in.nextLine();
        Integer productId = 4;
        String productName = "Espresso";
        System.out.println("Please Enter Your Mobile Number ");
        Long customerMobile = in.nextLong();
        System.out.println("How Many Cups of Espresso Do You Want to Order");
        int espressoQuantity = in.nextInt();
        Float amount = espressoQuantity*20.0F;

        if(cont.getCoffee_container()>=(15*espressoQuantity) && cont.getWater_container()>=(20*espressoQuantity) &&
                cont.getMilk_container()>=(120*espressoQuantity) && cont.getSugar_container()>=(20*espressoQuantity)){

        	Order order = new Order(productName,productId,amount,espressoQuantity,customerName,customerMobile);
            order.recordOrderData(order);
            System.out.println("Order values are recorded to Sales Table");
            
            System.out.println("Taking Your Order Please Wait for a while");

            System.out.println("Your Order is Ready. Please pay Rs."+amount+".");

            cont.setCoffee_container(cont.getCoffee_container() - espressoQuantity*15);
            cont.setWater_container(cont.getWater_container() - espressoQuantity*20);
            cont.setMilk_container(cont.getMilk_container() - espressoQuantity*120);
            cont.setSugar_container(cont.getSugar_container() - espressoQuantity*20);
            cont.setTea_container(cont.getTea_container() - 0);

        }else{
            System.out.println("Sorry Your Order cannot be processed because of Insufficient Raw Material.");
        }
    }
    /**
     * This Method will Refill The Container
     */
    
    private void onRefillContainer() {
        cont.setCoffee_container(2000.0F);
        cont.setTea_container(2000.0F);
        cont.setSugar_container(8000.0F);
        cont.setWater_container(15000.0F);
        cont.setMilk_container(1000.0F);

        counter = counter + 1;
        System.out.println("Container Refilled Successful");
        System.out.println("Container Refilled "+counter+" Times.");
    }

    /**
     * This Method will Show the Individual Sales List of each Order
     */
    private void onCheckTotalSale() {

        System.out.println("Total Sales Report ");
        List<Order> orderList= salesDetailsDAO.retriveSalesDetails();
        System.out.println("Size" + orderList.size());
        for(int i=0;i<orderList.size();i++){
            Order o = orderList.get(i);
            System.out.println((i+1)+". Customer Name:"+o.getCustomerName()+
                    "\n Date:"+o.getDate()+"\n Product:"+o.getProductName()+
                    "\n Quantity:"+o.getQuantity()+"\n Amount:"+o.getAmount()+"\n Mobile:"+o.getCustomerMobileNo()+
                    "\n Order Id:"+o.getOrderId());
        }
    }

    /**
     * This Method Shows the Quantity Available of The Container used to Prepare Drinks
     */
    private void onContainerStatus() {
        System.out.println("Container Status:");
        System.out.println("Coffee Container = "+cont.getCoffee_container()+" Grams");
        System.out.println("Tea Container = "+cont.getTea_container()+" Grams");
        System.out.println("Sugar Container = "+cont.getSugar_container()+" Grams");
        System.out.println("Milk Container = "+cont.getMilk_container()+" ml");
        System.out.println("Water Container = "+cont.getWater_container()+" ml");
    }
  
//   public void writeToCustomerTable(String customerName, String)
   

}
