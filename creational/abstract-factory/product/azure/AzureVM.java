package product.azure; 
import product.ComputeInstance;

/**
 * Azure VM implementation of compute instance.
 */
public class AzureVM implements ComputeInstance {
    private String vmName = "azure-vm-67890";
    
    @Override
    public void start() {
        System.out.println("Starting Azure VM: " + vmName);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Azure Virtual Machine - " + vmName);
    }
}