import java.util.ArrayList;
import java.util.List;

public class Repository {

    public List<Container> container = new ArrayList();

    public List<Order> orderList = new ArrayList();

    private static Repository repository; //Private constructor to restrict object creation from Outside.

    private Repository(){
    }

    public static Repository getRepository(){
        if(repository==null){
            repository = new Repository();
        }
        return repository;
    }
}
