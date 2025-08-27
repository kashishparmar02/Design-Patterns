# **Composite Pattern – Task Management System**

This project demonstrates the **Composite Design Pattern** through a task management system that treats individual tasks and project collections uniformly. The pattern allows you to compose objects into tree structures to represent part-whole hierarchies.

## **Project Structure**
```
composite/
├── TaskComponent.java                  (Component Interface)
├── leaf/
│   └── Task.java                      (Leaf Component)
├── composite_component/
│   └── Project.java                   (Composite Component)
├── client/
│   └── TaskManager.java               (Client)
└── CompositeDemo.java                 (Demo)
```

## **Implementation Flow**
1. **Component interface (TaskComponent)** defines the contract for both leaf and composite objects
2. **Leaf component (Task)** represents individual tasks that cannot have children
3. **Composite component (Project)** can contain both tasks and other projects
4. **Client (TaskManager)** works with the component interface uniformly
5. **Recursive operations** allow operations on composites to cascade to all children

## **Pattern Benefits**
* **Composite Pattern** allows treating individual objects and compositions uniformly
* Client code works the same way with both simple and complex objects
* Easy to add new types of components without changing existing code
* Follows Open/Closed Principle - open for extension, closed for modification
* Enables recursive operations across the entire object tree

## **Key Components**

### **Component Interface (TaskComponent)**
- `complete()` - Mark component as completed
- `getDuration()` - Get total duration in hours
- `display(String indent)` - Display with proper formatting
- `getName()` - Get component name
- `isCompleted()` - Check completion status
- `add(TaskComponent)` - Add child component (composites only)
- `remove(TaskComponent)` - Remove child component (composites only)

### **Leaf Component (Task)**
- **Task**: Represents individual work items with assignee and duration
- Cannot have child components (throws exception if add/remove called)

### **Composite Component (Project)**
- **Project**: Can contain both Task objects and other Project objects
- Operations cascade recursively to all child components
- Completion status depends on all children being completed

### **Client (TaskManager)**
- Uses TaskComponent interface without knowing specific implementations
- Can operate on both individual tasks and complex project hierarchies
- Provides status reporting and work completion functionality

## **Running the Demo**
```bash
# Navigate to parent directory of composite folder
cd structural

# Compile all files
javac composite/*.java composite/*/*.java

# Run demo
java structural.composite.CompositeDemo
```

The demo demonstrates:
- Creating individual tasks (leaf components)
- Building project hierarchies (composite components)
- Uniform treatment of tasks and projects through common interface
- Individual task completion vs. recursive project completion
- Status reporting across the entire hierarchy

## **Real-World Applications**
* **File System Management**: Files and directories in operating systems
* **Organization Hierarchies**: Employees, departments, and company structures
* **UI Component Trees**: Widgets, panels, and windows in graphical interfaces
* **Document Structures**: Paragraphs, sections, and chapters in documents
* **Menu Systems**: Menu items and submenus in applications 