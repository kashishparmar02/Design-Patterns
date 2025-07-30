package product.aws; 
import product.Storage;

/**
 * AWS S3 implementation of storage service.
 */
public class S3Storage implements Storage {
    private String bucketName = "my-aws-bucket";
    
    @Override
    public void uploadFile(String fileName) {
        System.out.println("Uploading " + fileName + " to S3 bucket: " + bucketName);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("AWS S3 Storage - " + bucketName);
    }
}