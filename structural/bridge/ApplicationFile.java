package structural.bridge;

/**
 * The Abstraction. It represents a file from an application's perspective
 * and holds the bridge to a FileSystem implementation.
 */
public abstract class ApplicationFile {
    protected FileSystem fileSystem; // The bridge
    protected String filePath;

    protected ApplicationFile(String path, FileSystem fs) {
        this.filePath = path;
        this.fileSystem = fs;
    }

    public abstract void save(byte[] data);
    public abstract byte[] read();
}