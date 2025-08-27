package structural.bridge;

import structural.bridge.concreteimplementers.FAT32FileSystem;
import structural.bridge.concreteimplementers.Ext4FileSystem;
import structural.bridge.concreteimplementers.NTFSFileSystem;

/**
 * The Client demonstrates how Abstractions (ApplicationFile types) can work
 * with any Implementation (FileSystem types).
 */
public class FileSystemClient {
    public static void main(String[] args) {
        // --- Create the low-level implementations (the drivers) ---
        FileSystem ntfs = new NTFSFileSystem();
        FileSystem ext4 = new Ext4FileSystem();
        FileSystem fat32 = new FAT32FileSystem();

        System.out.println("--- Scenario 1: Saving a text file on a Windows machine ---");
        // Bridge a high-level TextFile with the NTFS implementation
        ApplicationFile doc = new TextFile("/users/docs/report.txt", ntfs);
        doc.save("This is my report".getBytes());
        
        System.out.println("\n--- Scenario 2: Saving an encrypted file on a Linux server ---");
        // Bridge a high-level EncryptedFile with the ext4 implementation
        ApplicationFile secureData = new EncryptedFile("/etc/secret.dat", ext4);
        secureData.save("MyPassword123".getBytes());
        secureData.read();

        System.out.println("\n--- Scenario 3: Saving a text file to a USB stick ---");
        // Bridge the same TextFile abstraction with the FAT32 implementation
        ApplicationFile usbFile = new TextFile("E:/photo-notes.txt", fat32);
        usbFile.save("Notes about vacation photos".getBytes());
    }
}