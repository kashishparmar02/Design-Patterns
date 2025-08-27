package structural.bridge;

/**
 * The Implementation interface.
 * Defines the low-level operations for a file system.
 */
public interface FileSystem {
    void writeFile(String path, byte[] content);
    byte[] readFile(String path);
}
