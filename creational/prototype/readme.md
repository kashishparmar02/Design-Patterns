# **Prototype Pattern – Server Configuration System**

This project demonstrates the **Prototype Pattern** design pattern through a server template cloning system. The pattern allows creating new objects by copying existing instances, avoiding expensive initialization processes.

## **Project Structure**
* **ServerPrototype.java**: Interface defining the contract for cloneable server objects.
* **ServerTemplate.java**: Concrete implementation with cloning capability and heavy initialization.
* **PrototypeDemo.java**: Demonstrates creating different server types from a master template.

## **Cloning Workflow**
1. **Master template created** with expensive initialization (OS setup, base configuration).
2. **Clone method invoked** to create copies without re-running heavy processes.
3. **Individual configuration applied** to each cloned server (hostname, IP, specs).
4. **Server specifications modified** based on specific requirements (CPU, RAM).
5. **Final configurations displayed** showing customized server instances.

## **Pattern Advantages**
* **Prototype Pattern** eliminates costly object creation by copying existing instances.
* Avoids expensive initialization operations for similar objects.
* Provides flexibility to customize cloned objects independently.
* Reduces system load when creating multiple similar objects.
* Supports runtime object creation without knowing specific classes.

## **Running the Demo**
```bash
javac *.java
java PrototypeDemo
```

The demo creates a master server template, then clones it to generate web server, database server, and development server instances with different configurations and specifications.