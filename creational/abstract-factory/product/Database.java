package product;
/**
 * Abstract product for database services across cloud providers.
 */
public interface Database {
    void connect();
    void displayInfo();
}