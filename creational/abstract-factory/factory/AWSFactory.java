package factory;
import product.*;
import product.aws.*;

/**
 * AWS factory creates Amazon-specific infrastructure components.
 */
public class AWSFactory implements CloudFactory {
    
    @Override
    public ComputeInstance createComputeInstance() {
        return new EC2Instance();
    }
    
    @Override
    public Database createDatabase() {
        return new RDSDatabase();
    }
    
    @Override
    public Storage createStorage() {
        return new S3Storage();
    }
}