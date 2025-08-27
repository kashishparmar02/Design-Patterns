package structural.bridge.concreteimplementers;

import structural.bridge.FileSystem;

// Concrete Implementation for Windows NT File System
public class NTFSFileSystem implements FileSystem {
    @Override
    public void writeFile(String path, byte[] content) {
        System.out.println("Writing file '" + path + "' using NTFS-specific block allocation...");
    }

    @Override
    public byte[] readFile(String path) {
        System.out.println("Reading file '" + path + "' using NTFS Master File Table...");
        return ("NTFS content for " + path).getBytes();
    }
}