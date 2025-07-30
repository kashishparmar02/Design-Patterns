package client;
import factory.CloudFactory;
import product.*;

/**
 * Client that uses cloud infrastructure without knowing specific implementations.
 * This demonstrates the key benefit: same code works with any cloud provider.
 */
public class CloudInfrastructureManager {
    private CloudFactory factory;
    
    public CloudInfrastructureManager(CloudFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Deploy application using factory products.
     * Notice: no AWS or Azure specific code here!
     */
    public void deployApplication() {
        System.out.println("Deploying application...");
        
        // Create infrastructure components - all from same family
        ComputeInstance server = factory.createComputeInstance();
        Database database = factory.createDatabase();
        Storage storage = factory.createStorage();
        
        // Use the components
        server.start();
        database.connect();
        storage.uploadFile("application.jar");
        
        // Display deployment info
        System.out.println("\nDeployment Summary:");
        server.displayInfo();
        database.displayInfo();
        storage.displayInfo();
    }
}