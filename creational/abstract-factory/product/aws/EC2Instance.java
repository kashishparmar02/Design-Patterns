package product.aws; 
import product.ComputeInstance;

/**
 * AWS EC2 implementation of compute instance.
 */
public class EC2Instance implements ComputeInstance {
    private String instanceId = "i-aws-12345";
    
    @Override
    public void start() {
        System.out.println("Starting AWS EC2 instance: " + instanceId);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("AWS EC2 Instance - " + instanceId);
    }
}