import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.createTables();
        service.showMenu();
    }
}