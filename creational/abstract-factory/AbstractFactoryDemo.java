

import factory.*;
import client.CloudInfrastructureManager;

/**
 * Demo showing Abstract Factory pattern with cloud infrastructure.
 * Same client code works with different cloud providers.
 */
public class AbstractFactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern Demo ===\n");
        
        // Deploy on AWS
        System.out.println("--- Deploying on AWS ---");
        CloudFactory awsFactory = new AWSFactory();
        CloudInfrastructureManager awsManager = new CloudInfrastructureManager(awsFactory);
        awsManager.deployApplication();
        
        System.out.println("\n" + "=".repeat(50) + "\n");
        
        // Deploy on Azure - same client code!
        System.out.println("--- Deploying on Azure ---");
        CloudFactory azureFactory = new AzureFactory();
        CloudInfrastructureManager azureManager = new CloudInfrastructureManager(azureFactory);
        azureManager.deployApplication();
        
        System.out.println("\n=== Demo Completed ===");
    }
}