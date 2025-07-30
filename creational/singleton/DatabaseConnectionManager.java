public class DatabaseConnectionManager {
    // volatile ensures visibility between threads
    private static volatile DatabaseConnectionManager instance;

    // Private constructor
    private DatabaseConnectionManager() {
        System.out.println("Establishing database connection...");
        // Simulate connection creation delay
        try {
            Thread.sleep(1000); // simulate expensive resource creation
        } catch (InterruptedException e) {
            System.out.println("Connection initialization interrupted: " + e.getMessage());
        }
    }

    // Double-checked locking
    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionManager.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionManager();
                }
            }
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }
}
