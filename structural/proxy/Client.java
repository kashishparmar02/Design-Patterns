package structural.proxy;

/**
 * The Client class demonstrates the use of the Proxy pattern.
 */
public class Client {
    public static void main(String[] args) {
        // The client interacts with the proxy, unaware of the underlying origin server.
        Video videoPlayer = new CDNCacheProxy("cat_video_4k.mp4");

        System.out.println("--- First time video request ---");
        long startTime = System.currentTimeMillis();
        videoPlayer.getVideoContent(); // This will be slow
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms\n");

        System.out.println("--- Requesting the same video again ---");
        startTime = System.currentTimeMillis();
        videoPlayer.getVideoContent(); // This should be instantaneous
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
    
}
