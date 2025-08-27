package structural.bridge;

public class TextFile extends ApplicationFile {
    public TextFile(String path, FileSystem fs) {
        super(path, fs);
    }

    @Override
    public void save(byte[] data) {
        System.out.println("Saving a simple text file...");
        // Delegate the actual writing to the implementation via the bridge
        fileSystem.writeFile(filePath, data);
    }

    @Override
    public byte[] read() {
        System.out.println("Reading a simple text file...");
        return fileSystem.readFile(filePath);
    }
}