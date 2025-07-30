/**
 * Demo showing how to use our HttpRequest.Builder,
 * with "fail fast" validation in build() and
 * single-point logging of bad input here.
 */
public class BuilderDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Demo ===");
        runDemo();
    }
    
    public static void runDemo() {
        System.out.println("=== HTTP Request Builder Demo Started ===");

        // 1) Simple GET
        try {
            HttpRequest getReq = new HttpRequest.Builder(
                    "https://api.example.com/status",
                    "GET")
                    .addParam("verbose", "true")
                    .timeout(1000)
                    .build();      // may throw IllegalStateException
            getReq.send();
        }
        catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("Failed to build/send GET request: " + ex.getMessage());
        }

        // 2) POST with headers and JSON body
        try {
            String json = "{\"name\":\"Alice\",\"role\":\"admin\"}";
            HttpRequest postReq = new HttpRequest.Builder(
                    "https://api.example.com/users",
                    "POST")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer token_xyz")
                    .body(json)
                    .timeout(5000)
                    .followRedirects(false)
                    .build();     // may throw IllegalStateException
            postReq.send();
        }
        catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("Failed to build/send POST request: " + ex.getMessage());
        }

        System.out.println("=== HTTP Request Builder Demo Finished ===");

        // 3) Invalid request: missing URL and bad method
        try {
            System.out.println(">>> Now building a bad request to trigger error");
            HttpRequest badReq = new HttpRequest.Builder(
                    "",        // empty URL → invalid
                    "FOOBAR")  // unsupported method → invalid
                    .build();  // throws IllegalArgumentException/IllegalStateException
            badReq.send();
        }
        catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println("Caught expected builder error: " + ex.getMessage());
        }
    }
}