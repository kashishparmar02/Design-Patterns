public class ServerTemplate implements ServerPrototype, Cloneable {
    private String osType;
    private int cpuCores;
    private int ramGB;
    private String hostname;
    private String ipAddress;

    public ServerTemplate(String osType, int cpuCores, int ramGB) {
        this.osType = osType;
        this.cpuCores = cpuCores;
        this.ramGB = ramGB;
        performHeavyInitialization();
    }

    private void performHeavyInitialization() {
        System.out.println("Performing heavy initialization for " + osType + " server...");
        try {
            Thread.sleep(1000);
            System.out.println("Base image creation completed");
        } catch (InterruptedException e) {
            System.out.println("Initialization interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public ServerPrototype clone() {
        System.out.println("Cloning server template...");
        try {
            // Call the Object.clone() method
            ServerTemplate clone = (ServerTemplate) super.clone();
            // No need to perform heavy initialization again
            System.out.println("Created clone from template");
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
            return null; // Or throw a runtime exception
        }
    }

    @Override
    public void configure(String hostname, String ipAddress) {
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        System.out.println("Configured server: " + hostname + " (" + ipAddress + ")");
    }

    @Override
    public void displayConfiguration() {
        System.out.println(this.toString());
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
        System.out.println("Updated CPU cores to: " + cpuCores);
    }

    public void setRamGB(int ramGB) {
        this.ramGB = ramGB;
        System.out.println("Updated RAM to: " + ramGB + "GB");
    }

    @Override
    public String toString() {
        return "Server Configuration [" +
                "OS: " + osType +
                ", CPU Cores: " + cpuCores +
                ", RAM: " + ramGB + "GB" +
                ", Hostname: " + hostname +
                ", IP: " + ipAddress + ']';
    }
}