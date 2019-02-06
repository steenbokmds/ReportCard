package database;

//import database.MySqlRepository;

public class Repository {
    private static Repository ourInstance = new Repository();

    public static Repository getInstance() {
        return ourInstance;
    }

    private Repository() {
    }


    public MySqlRepository getShopRepository(){
        return new MySqlRepository();
    }
}
