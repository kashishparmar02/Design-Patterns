package structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class CDNCacheProxy implements Video {
    private final Map<String, byte[]> cache = new HashMap<>();
    private final MainServer mainServer;

    public CDNCacheProxy(String videoId) {
        this.mainServer = new MainServer(videoId);
    }

    @Override
    public String getVideoId() {
        return this.mainServer.getVideoId();
    }

    @Override
    public byte[] getVideoContent() {
        String videoId = this.mainServer.getVideoId();
        
        // Check if the content is in our local cache
        if (cache.containsKey(videoId)) {
            System.out.printf("Serving '%s' from CDN Cache. (Fast)%n", videoId);
            return cache.get(videoId);
        }
        
        // If not in cache, fetch from the real server
        byte[] content = this.mainServer.getVideoContent();
        
        // Store the newly fetched content in the cache for future requests
        cache.put(videoId, content);
        
        return content;
    }
    
    
    
}
