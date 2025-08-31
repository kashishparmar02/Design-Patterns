package creational.singleton;

/**
 * Singleton Pattern Demonstration
 * 
 * Real-world Scenarios:
 * 1. CacheManager - Eager initialization for frequently used resources
 * 2. DatabaseConnectionManager - Lazy initialization for expensive resources
 
 * @author Kashish Parmar
 */

public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Demo ===\n");
        
        demonstrateEagerSingleton();
        System.out.println("\n" + "=".repeat(50) + "\n");
        demonstrateLazySingleton();
    }

    /**
     * Demonstrates Eager Singleton (Thread-safe by default)
     * Use case: Configuration cache that's always needed
     */
    private static void demonstrateEagerSingleton() {

        System.out.println("1. EAGER SINGLETON: CacheManager");
        System.out.println("   Use case: Application configuration cache\n");


        System.out.println("Requesting first CacheManager instance...");
        CacheManager cache1 = CacheManager.getInstance();

        System.out.println("Requesting second CacheManager instance...");
        CacheManager cache2 = CacheManager.getInstance();

        // Verification
        System.out.println("\nVerification:");
        System.out.println("Instance 1 hash: " + cache1.hashCode());
        System.out.println("Instance 2 hash: " + cache2.hashCode());
        System.out.println("App name from cache: " + cache1.getCacheValue("appName"));

        if (cache1 == cache2) {
            System.out.println("Eager Singleton working correctly!");
        } else {
            System.out.println("Singleton pattern broken!");
        }
    }

    /**
     * Demonstrates Lazy Singleton with Double-Checked Locking
     * Use case: Expensive database connection that may not be needed immediately
     */
    private static void demonstrateLazySingleton() {
        System.out.println("2. LAZY SINGLETON: DatabaseConnectionManager");
        System.out.println("   Use case: Expensive database connection\n");

        System.out.println("Requesting first DatabaseConnectionManager instance...");
        DatabaseConnectionManager db1 = DatabaseConnectionManager.getInstance();

        System.out.println("Requesting second DatabaseConnectionManager instance...");
        DatabaseConnectionManager db2 = DatabaseConnectionManager.getInstance();

        System.out.println("\nVerification:");
        System.out.println("Instance 1 hash: " + db1.hashCode());
        System.out.println("Instance 2 hash: " + db2.hashCode());

        // Demonstrate functionality
        db1.connect();

        if (db1 == db2) {
            System.out.println("Lazy Singleton working correctly!");
        } else {
            System.out.println("Singleton pattern broken!");
        }
    }
}