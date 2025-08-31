package behavioral.chain_of_responsibilty;

/**
 * Abstract Handler - defines the chain structure
 */
public abstract class RequestHandler {
    protected RequestHandler nextHandler;
    
    public void setNext(RequestHandler handler) {
        this.nextHandler = handler;
    }
    
    public abstract String handle(HttpRequest request);
    
    protected String passToNext(HttpRequest request) {
        if (nextHandler != null) {
            return nextHandler.handle(request);
        }
        return "No handler available";
    }
} 