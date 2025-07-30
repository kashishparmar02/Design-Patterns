import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public final class HttpRequest {
    // ——— Required ———
    private final String url;
    private final String method;
    // ——— Optional ———
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final int timeoutMs;
    private final boolean followRedirects;

    // Private constructor: only Builder can instantiate
    private HttpRequest(Builder b) {
        this.url             = b.url;
        this.method          = b.method.toUpperCase();
        this.headers         = Collections.unmodifiableMap(b.headers);
        this.queryParams     = Collections.unmodifiableMap(b.queryParams);
        this.body            = b.body;
        this.timeoutMs       = b.timeoutMs;
        this.followRedirects = b.followRedirects;
    }

    // Simulate sending the request
    public void send() {
        System.out.println("---- Sending HTTP " + method + " ----");
        System.out.println("URL: " + url);
        System.out.println("Headers: " + headers);
        System.out.println("Params: " + queryParams);
        if (body != null) {
            System.out.println("Body: " + body);
        }
        System.out.println("Timeout: " + timeoutMs + "ms");
        System.out.println("FollowRedirects: " + followRedirects);
        System.out.println("Request completed.\n");
    }

    /**
     * The Builder—nested static class in same file is allowed (and common).
     * It collects parameters, enforces required fields in ctor, and
     * returns a fully-built, immutable HttpRequest via build().
     */
    public static class Builder {
        // Required
        private final String url;
        private final String method;
        // Optional (with defaults)
        private Map<String, String> headers    = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body                   = null;
        private int timeoutMs                 = 3000;
        private boolean followRedirects       = true;

        public Builder(String url, String method) {
            if (url == null || url.isEmpty()) {
                throw new IllegalArgumentException("URL is required");
            }
            if (method == null || method.isEmpty()) {
                throw new IllegalArgumentException("Method is required");
            }
            this.url    = url;
            this.method = method;
        }

        public Builder addHeader(String name, String value) {
            headers.put(name, value);
            return this;
        }

        public Builder addParam(String name, String value) {
            queryParams.put(name, value);
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder timeout(int milliseconds) {
            this.timeoutMs = milliseconds;
            return this;
        }

        public Builder followRedirects(boolean follow) {
            this.followRedirects = follow;
            return this;
        }

        public HttpRequest build() {
            // Validate HTTP method
            String m = method.toUpperCase();
            if (!m.matches("GET|POST|PUT|DELETE|PATCH|HEAD")) {
                throw new IllegalStateException("Unsupported HTTP method: " + method);
            }
            System.out.println("Building HttpRequest: " + m + " " + url);
            return new HttpRequest(this);
        }
    }
}
