package product;
/**
 * Abstract product for storage services across cloud providers.
 */
public interface Storage {
    void uploadFile(String fileName);
    void displayInfo();
}