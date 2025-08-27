package structural.proxy;

import java.util.concurrent.TimeUnit;

public class MainServer implements Video {
    private final String videoId;
    private byte[] videoContent;

    public MainServer(String videoId) {
        this.videoId = videoId;
        this.videoContent = null; // Lazy loading - don't load immediately
    }

    @Override
    public byte[] getVideoContent() {
        if (videoContent == null) {
            videoContent = loadVideoFromSource();
        }
        return videoContent;
    }

    @Override
    public String getVideoId() {
        return this.videoId;
    }
    
     /**
     * A private helper method to simulate a slow, expensive operation.
     */
    private byte[] loadVideoFromSource() {
        System.out.printf("Fetching video '%s' from remote Origin Server... (This is slow)%n", videoId);
        try {
            // Simulate a 2-second network delay
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Finished downloading '%s'.%n", videoId);
        return ("Dummy content for " + videoId).getBytes();
    }
}
