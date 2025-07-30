public interface ServerPrototype {
    ServerPrototype clone();
    void configure(String hostname, String ipAddress);
    void displayConfiguration();
}
