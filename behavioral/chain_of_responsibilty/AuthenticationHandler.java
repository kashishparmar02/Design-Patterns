package behavioral.chain_of_responsibilty;

/**
 * Concrete Handler - checks authentication
 */
public class AuthenticationHandler extends RequestHandler {
    
    @Override
    public String handle(HttpRequest request) {
        System.out.println("AuthenticationHandler: Checking token...");
        
        if (request.getToken() == null || request.getToken().isEmpty()) {
            return "401 Unauthorized - No token provided";
        }
        
        if (!request.getToken().equals("valid-token")) {
            return "401 Unauthorized - Invalid token";
        }
        
        System.out.println("✓ Authentication passed");
        return passToNext(request);
    }
} 