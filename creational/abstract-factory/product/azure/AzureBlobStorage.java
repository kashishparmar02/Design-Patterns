package product.azure; 
import product.Storage;

/**
 * Azure Blob implementation of storage service.
 */
public class AzureBlobStorage implements Storage {
    private String containerName = "my-azure-container";
    
    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " to Azure Blob: " + containerName);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Azure Blob Storage - " + containerName);
    }
}