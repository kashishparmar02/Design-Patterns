package behavioral.chain_of_responsibilty;

/**
 * Concrete Handler - checks user permissions
 */
public class AuthorizationHandler extends RequestHandler {
    
    @Override
    public String handle(HttpRequest request) {
        System.out.println("AuthorizationHandler: Checking permissions...");
        
        // Admin can access everything
        if ("admin".equals(request.getUserRole())) {
            System.out.println("✓ Admin access granted");
            return passToNext(request);
        }
        
        // Users can only GET, not POST/DELETE
        if ("user".equals(request.getUserRole()) && "GET".equals(request.getMethod())) {
            System.out.println("✓ User read access granted");
            return passToNext(request);
        }
        
        return "403 Forbidden - Insufficient permissions";
    }
} 