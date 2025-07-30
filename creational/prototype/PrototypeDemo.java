public class PrototypeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern Demo ===");
        runDemo();
    }
    
    public static void runDemo() {
        System.out.println("Prototype Pattern Demo Started!");

        // Create prototype instance
        ServerPrototype masterTemplate = new ServerTemplate("Ubuntu 22.04", 4, 16);
        System.out.println("Master template created");

        try {
            System.out.println("\n--- Creating Web Server ---");
            ServerPrototype webServer = masterTemplate.clone();
            if (webServer != null) {
                webServer.configure("web-server-01", "10.0.1.10");
                ((ServerTemplate) webServer).setCpuCores(8);
                webServer.displayConfiguration();
            } else {
                System.out.println("Failed to clone web server template");
            }

            System.out.println("\n--- Creating DB Server ---");
            ServerPrototype dbServer = masterTemplate.clone();
            if (dbServer != null) {
                dbServer.configure("db-server-01", "10.0.1.20");
                ((ServerTemplate) dbServer).setRamGB(64);
                dbServer.displayConfiguration();
            } else {
                System.out.println("Failed to clone db server template");
            }

            System.out.println("\n--- Creating Dev Server ---");
            ServerPrototype devServer = masterTemplate.clone();
            if (devServer != null) {
                devServer.configure("dev-server-01", "10.0.2.10");
                ((ServerTemplate) devServer).setCpuCores(2);
                ((ServerTemplate) devServer).setRamGB(8);
                devServer.displayConfiguration();
            } else {
                System.out.println("Failed to clone dev server template");
            }
        } catch (Exception e) {
            System.out.println("Error during prototype operations: " + e.getMessage());
        }

        System.out.println("Prototype Pattern Demo Completed!");
    }
}