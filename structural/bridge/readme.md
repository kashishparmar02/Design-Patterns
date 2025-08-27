# **Bridge Pattern – File System Abstraction**

This project demonstrates the **Bridge Design Pattern** through a file system abstraction that separates file types from their underlying file system implementations. The pattern decouples an abstraction from its implementation, allowing both to vary independently.

## **Project Structure**
```
bridge/
├── ApplicationFile.java                (Abstraction)
├── TextFile.java                      (Refined Abstraction)
├── EncryptedFile.java                 (Refined Abstraction)
├── FileSystem.java                    (Implementation Interface)
├── concreteimplementers/
│   ├── NTFSFileSystem.java           (Concrete Implementation)
│   ├── Ext4FileSystem.java           (Concrete Implementation)
│   └── FAT32FileSystem.java          (Concrete Implementation)
└── FileSystemClient.java             (Client/Demo)
```

## **Pattern Overview**

The Bridge pattern separates the abstraction (what the client sees) from the implementation (how it actually works). This allows:
- Different file types (Text, Encrypted) to work with any file system
- New file types can be added without changing file systems
- New file systems can be added without changing file types
- Runtime selection of implementation

## **Implementation Flow**
1. **Abstraction (ApplicationFile)** defines the high-level interface and holds a reference to the implementation
2. **Refined Abstractions (TextFile, EncryptedFile)** extend the abstraction with specific behaviors
3. **Implementation Interface (FileSystem)** defines low-level operations
4. **Concrete Implementations (NTFS, ext4, FAT32)** provide platform-specific file system operations
5. **Client** can combine any abstraction with any implementation at runtime

## **Key Components**

### **Abstraction Layer**

#### **ApplicationFile (Abstract Base Class)**
- Holds the bridge to `FileSystem` implementation
- Defines common interface for all file types
- Methods: `save(byte[] data)`, `read()`

#### **TextFile (Refined Abstraction)**
- Handles plain text files
- Delegates storage operations to the file system implementation
- Adds text-specific processing logic

#### **EncryptedFile (Refined Abstraction)**
- Handles encrypted files with automatic encryption/decryption
- Encrypts data before saving, decrypts after reading
- Uses same file system operations but adds security layer

### **Implementation Layer**

#### **FileSystem (Implementation Interface)**
- Defines low-level file operations
- Methods: `writeFile(String path, byte[] content)`, `readFile(String path)`

#### **NTFSFileSystem (Concrete Implementation)**
- Simulates Windows NTFS file system operations
- Uses NTFS-specific terminology (block allocation, Master File Table)

#### **Ext4FileSystem (Concrete Implementation)**
- Simulates Linux ext4 file system operations  
- Uses ext4-specific terminology (journaling, inodes)

#### **FAT32FileSystem (Concrete Implementation)**
- Simulates FAT32 file system operations (USB drives, older systems)
- Uses FAT32-specific terminology (file allocation table, cluster chains)

## **Pattern Benefits**

### **Separation of Concerns**
- File types (abstraction) are independent of file systems (implementation)
- Changes to file systems don't affect file type logic
- Changes to file types don't affect file system implementations

### **Runtime Flexibility**
- Same file type can work with different file systems
- Implementation can be chosen at runtime based on platform or requirements
- Easy switching between implementations for testing or deployment

### **Extensibility**
- Add new file types (e.g., `CompressedFile`, `BackupFile`) without changing existing code
- Add new file systems (e.g., `ZFSFileSystem`, `BtrfsFileSystem`) without affecting file types
- Follows Open/Closed Principle

### **Code Reusability**
- File system implementations can be reused across different file types
- File type logic can work with any compatible file system
- Reduces code duplication

## **Usage Examples**

### **Scenario 1: Text File on Windows**
```java
FileSystem ntfs = new NTFSFileSystem();
ApplicationFile document = new TextFile("/users/docs/report.txt", ntfs);
document.save("This is my report".getBytes());
```

### **Scenario 2: Encrypted File on Linux**
```java
FileSystem ext4 = new Ext4FileSystem();
ApplicationFile secureFile = new EncryptedFile("/etc/secret.dat", ext4);
secureFile.save("MyPassword123".getBytes());
byte[] decryptedData = secureFile.read();
```

### **Scenario 3: Same File Type, Different File System**
```java
FileSystem fat32 = new FAT32FileSystem();
ApplicationFile usbFile = new TextFile("E:/notes.txt", fat32);
usbFile.save("USB drive notes".getBytes());
```

## **Running the Demo**

### **Compile**
```bash
javac -d bin structural/bridge/*.java structural/bridge/concreteimplementers/*.java
```

### **Run**
```bash
java -cp bin structural.bridge.FileSystemClient
```

### **Expected Output**
```
--- Scenario 1: Saving a text file on a Windows machine ---
Saving a simple text file...
Writing file '/users/docs/report.txt' using NTFS-specific block allocation...

--- Scenario 2: Saving an encrypted file on a Linux server ---
Encrypting data for the file...
Writing file '/etc/secret.dat' using ext4 journaling...
Reading file '/etc/secret.dat' using ext4 inodes...
Decrypting data from the file...

--- Scenario 3: Saving a text file to a USB stick ---
Saving a simple text file...
Writing file 'E:/photo-notes.txt' using FAT32 file allocation table...
```

## **Real-World Applications**

### **Cross-Platform Software**
- Media players supporting different audio codecs
- Database applications working with various storage engines
- Graphics applications supporting multiple rendering backends

### **Driver Architecture**
- Operating system device drivers
- Printer drivers for different printer types
- Network protocol implementations

### **UI Frameworks**
- GUI frameworks supporting different operating systems
- Web frameworks with multiple rendering engines
- Game engines supporting various graphics APIs

## **Design Principles Demonstrated**

- **Single Responsibility Principle**: Each class has one reason to change
- **Open/Closed Principle**: Open for extension, closed for modification  
- **Dependency Inversion Principle**: Depend on abstractions, not concretions
- **Composition over Inheritance**: Uses composition to create the bridge
- **Loose Coupling**: Abstraction and implementation can vary independently

## **When to Use Bridge Pattern**

 **Use When:**
- You want to avoid permanent binding between abstraction and implementation
- Both abstraction and implementation should be extensible through subclassing
- Implementation details should be hidden from clients
- You have a proliferation of classes from a coupled interface and numerous implementations

 **Don't Use When:**
- You have only one implementation
- The abstraction and implementation are unlikely to change
- The added complexity isn't justified by the flexibility gained 