# **Singleton Pattern – Resource Management System**

This project demonstrates **two different Singleton implementations** through resource management scenarios. The pattern ensures only one instance of a class exists while providing global access to that instance.

## **Project Structure**
* **CacheManager.java**: Eager Singleton implementation for application configuration cache.
* **DatabaseConnectionManager.java**: Lazy Singleton with double-checked locking for expensive resources.
* **SingletonDemo.java**: Demonstrates both singleton types with real-world use cases.

## **Implementation Approaches**

### **Eager Singleton (CacheManager)**
- **Instance created** at class loading time regardless of usage
- **Thread-safe by default** due to JVM class loading mechanism
- **Best for frequently used** resources that are always needed

### **Lazy Singleton (DatabaseConnectionManager)**
- **Instance created** only when first requested
- **Double-checked locking** ensures thread safety with minimal performance impact
- **Ideal for expensive resources** that may not be immediately required

## **Initialization Flow**
1. **Eager Singleton**: Instance created during class loading, cache pre-populated
2. **Lazy Singleton**: Instance creation deferred until `getInstance()` called
3. **Thread safety ensured** through different mechanisms for each approach
4. **Single instance verification** performed through hash code comparison
5. **Functional demonstration** shows practical usage of both patterns

## **Pattern Benefits**
* **Singleton Pattern** guarantees single instance throughout application lifecycle
* Provides controlled access to shared resources like caches and connections
* Reduces memory footprint by preventing multiple instances of expensive objects
* Ensures consistency across different parts of the application
* Offers flexibility in initialization timing based on requirements

## **Running the Demo**
```bash
javac *.java
java SingletonDemo
```

The demo shows both eager and lazy initialization approaches, verifies singleton behavior through instance comparison, and demonstrates practical usage scenarios for each implementation type.