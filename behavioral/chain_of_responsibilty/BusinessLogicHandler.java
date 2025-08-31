package behavioral.chain_of_responsibilty;

/**
 * Concrete Handler - processes business logic (end of chain)
 */
public class BusinessLogicHandler extends RequestHandler {
    
    @Override
    public String handle(HttpRequest request) {
        System.out.println("BusinessLogicHandler: Processing request...");
        
        // This is the end of the chain - always handles the request
        String response = "200 OK - " + request.getMethod() + " " + request.getUrl() + " processed successfully";
        System.out.println("✓ Request processed");
        return response;
    }
} 