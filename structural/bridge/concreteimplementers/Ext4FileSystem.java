package structural.bridge.concreteimplementers;

import structural.bridge.FileSystem;

// Concrete Implementation for Linux Extended File System 4
public class Ext4FileSystem implements FileSystem {
    @Override
    public void writeFile(String path, byte[] content) {
        System.out.println("Writing file '" + path + "' using ext4 journaling...");
    }

    @Override
    public byte[] readFile(String path) {
        System.out.println("Reading file '" + path + "' using ext4 inodes...");
        return ("ext4 content for " + path).getBytes();
    }
}