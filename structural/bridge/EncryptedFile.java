package structural.bridge;

public class EncryptedFile extends ApplicationFile {
    public EncryptedFile(String path, FileSystem fs) {
        super(path, fs);
    }

    @Override
    public void save(byte[] data) {
        System.out.println("Encrypting data for the file...");
        byte[] encryptedData = ("ENCRYPTED[" + new String(data) + "]").getBytes();
        // Delegate the writing of the *encrypted* data to the implementation
        fileSystem.writeFile(filePath, encryptedData);
    }

    @Override
    public byte[] read() {
        byte[] encryptedData = fileSystem.readFile(filePath);
        System.out.println("Decrypting data from the file...");
        // Simulate decryption
        return new String(encryptedData).replace("ENCRYPTED[", "").replace("]", "").getBytes();
    }
}