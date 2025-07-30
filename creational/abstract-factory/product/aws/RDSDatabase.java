package product.aws; 
import product.Database;

/**
 * AWS RDS implementation of database service.
 */
public class RDSDatabase implements Database {
    private String endpoint = "mydb.rds.amazonaws.com";
    
    @Override
    public void connect() {
        System.out.println("Connecting to AWS RDS: " + endpoint);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("AWS RDS Database - " + endpoint);
    }
}