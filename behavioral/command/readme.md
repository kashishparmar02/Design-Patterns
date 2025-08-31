# **Command Pattern – Asynchronous Video Processing System**

This project demonstrates the **Command Pattern** through an asynchronous video processing system. The pattern encapsulates requests as objects, allowing you to parameterize clients with different requests, queue operations, and support asynchronous execution.

## **Project Structure**
```
command/
├── command/
│   ├── Command.java                     (Command Interface)
│   └── ProcessVideoCommand.java         (Concrete Command)
├── invoker/
│   └── Worker.java                      (Invoker)
├── receiver/
│   └── VideoProcessingService.java      (Receiver)
└── Main.java                            (Client/Demo)
```

## **Command Execution Process**
1. **Client creates commands** encapsulating video processing requests with parameters
2. **Commands are queued** in a thread-safe blocking queue for asynchronous processing
3. **Invoker (Worker) pulls commands** from queue in background thread
4. **Commands execute** by delegating to receiver objects without invoker knowing specifics
5. **Receiver performs actual work** - video processing with time-consuming operations

## **Pattern Benefits**
* **Command Pattern** decouples request sender from request receiver
* Enables asynchronous processing - web server remains responsive during heavy operations
* Supports queuing, logging, and scheduling of operations
* Easy to add new command types without modifying existing code
* Commands can be parameterized, queued, and executed at different times
* Supports undo operations (extensible) and macro recording capabilities

## **Key Components**

### **Command Interface (Command)**
- `execute()` - Executes the encapsulated request
- Defines contract for all command objects

### **Concrete Command (ProcessVideoCommand)**
- Encapsulates video processing request with receiver and parameters
- Delegates execution to receiver object
- Self-contained with all information needed to perform action

### **Invoker (Worker)**
- Manages command queue and execution
- Runs in separate thread for asynchronous processing
- Doesn't know about specific command types or business logic
- Handles command lifecycle and thread management

### **Receiver (VideoProcessingService)**
- Performs actual business logic - video processing
- Knows how to handle video files and processing operations
- Contains the real implementation of the operation

### **Client (Main)**
- Creates and configures concrete command objects
- Adds commands to invoker's queue
- Simulates web server handling video uploads
- Remains responsive while background processing occurs

## **Running the Demo**
```bash
# Navigate to parent directory of command folder
cd behavioral

# Compile all files
javac -d ../bin command/*.java command/*/*.java

# Run demo
java -cp ../bin behavioral.command.Main
```

The demo demonstrates:
- Web server accepting video uploads without blocking
- Asynchronous video processing in background thread
- Command queuing and sequential execution
- Decoupled architecture between client, invoker, and receiver
- Responsive system design with time-consuming operations

## **Execution Flow Example**
```
Web server is running. Simulating video uploads...
UPLOADED: 'summer_vacation.mp4'. Task added to queue.     ← Command created & queued
UPLOADED: 'birthday_party.mov'. Task added to queue.      ← Command created & queued

All uploads finished. The server is free...               ← Client done, worker continues

-> Starting to process video: summer_vacation.mp4         ← Worker executes command
<- Finished processing video: summer_vacation.mp4         ← Receiver completes work

-> Starting to process video: birthday_party.mov          ← Worker executes next command
<- Finished processing video: birthday_party.mov          ← Receiver completes work
```

## **Real-World Applications**
* **GUI Applications**: Menu items, buttons, and keyboard shortcuts as command objects
* **Undo/Redo Systems**: Commands can store state for reversing operations
* **Macro Recording**: Commands can be recorded and replayed later
* **Thread Pools**: Background task processing with command queues
* **Remote Procedure Calls**: Commands can be serialized and sent over network
* **Database Transactions**: Commands can be grouped and executed atomically
* **Game Development**: Input handling, action replay, and AI behavior systems
* **Microservices**: Asynchronous message processing and event handling
