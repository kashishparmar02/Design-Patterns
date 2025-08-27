package structural.bridge.concreteimplementers;

import structural.bridge.FileSystem;

// Concrete Implementation for File Allocation Table 32 (e.g., USB drives)
public class FAT32FileSystem implements FileSystem {
    @Override
    public void writeFile(String path, byte[] content) {
        System.out.println("Writing file '" + path + "' using FAT32 file allocation table...");
    }

    @Override
    public byte[] readFile(String path) {
        System.out.println("Reading file '" + path + "' using FAT32 cluster chains...");
        return ("FAT32 content for " + path).getBytes();
    }
}