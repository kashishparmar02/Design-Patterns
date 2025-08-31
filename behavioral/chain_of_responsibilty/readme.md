# **Chain of Responsibility Pattern – HTTP Request Processing System**

This project demonstrates the **Chain of Responsibility pattern** through an HTTP request processing system. The pattern allows multiple handlers to process a request, with each handler deciding whether to handle the request or pass it to the next handler in the chain.

## **Project Structure**
* **RequestHandler.java**: Abstract handler defining the chain structure and common interface.
* **AuthenticationHandler.java**: Concrete handler for token validation and authentication.
* **AuthorizationHandler.java**: Concrete handler for permission checking and role-based access.
* **BusinessLogicHandler.java**: Concrete handler for final request processing (end of chain).
* **HttpRequest.java**: Request object containing method, URL, token, and user role information.
* **ChainOfResponsibilityDemo.java**: Demonstrates the pattern with various request scenarios.

## **Implementation Components**

### **Abstract Handler (RequestHandler)**
- **Defines chain structure** with `setNext()` method for linking handlers
- **Abstract handle() method** to be implemented by concrete handlers
- **passToNext() method** for forwarding requests down the chain
- **Provides common interface** for all request handlers

### **Concrete Handlers**
- **AuthenticationHandler**: Validates tokens and ensures user authentication
- **AuthorizationHandler**: Checks user permissions based on roles (admin/user)
- **BusinessLogicHandler**: Processes the actual business logic (end of chain)

### **Request Object (HttpRequest)**
- **Encapsulates request data** including HTTP method, URL, authentication token, and user role
- **Immutable data structure** that travels through the handler chain
- **Provides getter methods** for accessing request properties

## **Request Processing Flow**
1. **Request Creation**: HttpRequest object created with method, URL, token, and role
2. **Chain Setup**: Handlers linked in sequence: Auth → Authorization → Business Logic
3. **Authentication Check**: Token validation and user verification
4. **Authorization Check**: Role-based permission validation
5. **Business Processing**: Final request handling and response generation
6. **Response Return**: Appropriate HTTP status code and message returned

## **Pattern Benefits**
* **Decouples request senders from receivers** by allowing multiple handlers to process requests
* **Provides flexibility** in adding, removing, or reordering handlers without changing client code
* **Enables single responsibility principle** with each handler focusing on one aspect of processing
* **Supports dynamic chain composition** allowing different chains for different request types
* **Simplifies complex validation logic** by breaking it into manageable, focused components

## **Running the Demo**
```bash
javac *.java
java ChainOfResponsibilityDemo
```

The demo shows various request scenarios including valid admin requests, user requests, invalid tokens, and permission violations, demonstrating how the chain processes different types of requests and handles failures at appropriate levels.
