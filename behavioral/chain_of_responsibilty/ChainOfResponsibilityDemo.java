package behavioral.chain_of_responsibilty;

/**
 * Chain of Responsibility Pattern Demo - HTTP Request Processing
 * 
 * Shows how requests flow through a chain of handlers
 */
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Create the chain of handlers
        RequestHandler authHandler = new AuthenticationHandler();
        RequestHandler authzHandler = new AuthorizationHandler();
        RequestHandler businessHandler = new BusinessLogicHandler();
        
        // Build the chain: Auth → Authorization → Business Logic
        authHandler.setNext(authzHandler);
        authzHandler.setNext(businessHandler);
        
        System.out.println("=== Chain of Responsibility Pattern Demo ===\n");
        
        // Test case 1: Valid admin request
        System.out.println("1. Valid admin POST request:");
        HttpRequest request1 = new HttpRequest("POST", "/api/products", "valid-token", "admin");
        String result1 = authHandler.handle(request1);
        System.out.println("Result: " + result1 + "\n");
        
        // Test case 2: Valid user GET request
        System.out.println("2. Valid user GET request:");
        HttpRequest request2 = new HttpRequest("GET", "/api/users", "valid-token", "user");
        String result2 = authHandler.handle(request2);
        System.out.println("Result: " + result2 + "\n");
        
        // Test case 3: Invalid token
        System.out.println("3. Request with invalid token:");
        HttpRequest request3 = new HttpRequest("GET", "/api/data", "bad-token", "user");
        String result3 = authHandler.handle(request3);
        System.out.println("Result: " + result3 + "\n");
        
        // Test case 4: User trying forbidden action
        System.out.println("4. User trying POST (forbidden):");
        HttpRequest request4 = new HttpRequest("POST", "/api/data", "valid-token", "user");
        String result4 = authHandler.handle(request4);
        System.out.println("Result: " + result4 + "\n");
        

    }
} 