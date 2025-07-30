# **Builder Pattern – HTTP Request Builder**

This project demonstrates the **Builder Pattern** design pattern through an HTTP request construction system. The pattern allows creating complex objects step-by-step with a fluent interface while ensuring immutability and validation.

## **Project Structure**
* **HttpRequest.java**: Main class representing an immutable HTTP request object.
* **HttpRequest.Builder**: Nested static builder class for constructing HTTP requests.
* **BuilderDemo.java**: Demonstrates the pattern with various HTTP request scenarios.

## **Construction Process**
1. **Builder initialized** with required parameters (URL and HTTP method).
2. **Optional parameters added** through fluent method chaining.
3. **Validation performed** in the `build()` method before object creation.
4. **Immutable HttpRequest created** with all specified configurations.
5. **Request can be executed** through the `send()` method.

## **Pattern Benefits**
* **Builder Pattern** eliminates telescoping constructors with many parameters.
* Provides fluent, readable API for complex object construction.
* Ensures object immutability and thread-safety after creation.
* Centralizes validation logic in the `build()` method.
* Allows optional parameters with sensible defaults.

## **Running the Demo**
```bash
javac *.java
java BuilderDemo
```

The demo creates GET and POST requests with various configurations, and demonstrates error handling for invalid requests with proper validation feedback.