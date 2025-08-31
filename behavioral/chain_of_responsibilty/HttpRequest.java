package behavioral.chain_of_responsibilty;

/**
 * Request object that travels through the chain
 */
public class HttpRequest {
    private String method;
    private String url;
    private String token;
    private String userRole;
    
    public HttpRequest(String method, String url, String token, String userRole) {
        this.method = method;
        this.url = url;
        this.token = token;
        this.userRole = userRole;
    }
    
    public String getMethod() { return method; }
    public String getUrl() { return url; }
    public String getToken() { return token; }
    public String getUserRole() { return userRole; }
    
    @Override
    public String toString() {
        return method + " " + url + " [" + userRole + "]";
    }
} 