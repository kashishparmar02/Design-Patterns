package structural.proxy;

/**
 * The Subject interface, which defines the common operation for both the
 * Real Subject (OriginServer) and the Proxy (CDNCacheProxy).
 */
public interface Video {
    /**
     * Downloads the video content.
     * @return A byte array representing the video data.
     */
    byte[] getVideoContent();
    String getVideoId();
}