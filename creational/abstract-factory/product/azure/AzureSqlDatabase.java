package product.azure; 
import product.Database;

/**
 * Azure SQL implementation of database service.
 */
public class AzureSqlDatabase implements Database {
    private String serverName = "myserver.database.windows.net";
    
    @Override
    public void connect() {
        System.out.println("Connecting to Azure SQL: " + serverName);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Azure SQL Database - " + serverName);
    }
}