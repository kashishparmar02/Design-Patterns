
import java.util.HashMap;
import java.util.Map;

public class CacheManager {
    // Eager Singleton: instance created at class loading time
    private static final CacheManager instance = new CacheManager();

    private Map<String, String> cache = new HashMap<>();

    // Private constructor
    private CacheManager() {
        System.out.println("Initializing CacheManager and loading cache...");
        cache.put("appName", "DesignPatternsApp");
        cache.put("version", "1.0.0");
        cache.put("author", "Kashish Parmar");
    }

    // Public method to access singleton instance
    public static CacheManager getInstance() {
        return instance;
    }

    public String getCacheValue(String key) {
        return cache.get(key);
    }
}
