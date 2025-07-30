package factory;
import product.*;
import product.azure.*;

/**
 * Azure factory creates Microsoft-specific infrastructure components.
 */
public class AzureFactory implements CloudFactory {
    
    @Override
    public ComputeInstance createComputeInstance() {
        return new AzureVM();
    }
    
    @Override
    public Database createDatabase() {
        return new AzureSqlDatabase();
    }
    
    @Override
    public Storage createStorage() {
        return new AzureBlobStorage();
    }
}