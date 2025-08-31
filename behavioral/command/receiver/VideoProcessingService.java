package behavioral.command.receiver;


/**
 * The Receiver class. It knows how to perform the actual business logic.
 * This simulates a service that processes video files.
 */
public class VideoProcessingService {

    public void processVideo(String videoFile) {
        System.out.println("-> Starting to process video: " + videoFile);
        try {
            // Simulate a time-consuming video processing task (e.g., encoding)
            Thread.sleep(3000); // Sleep for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Processing was interrupted for: " + videoFile);
        }
        System.out.println("<- Finished processing video: " + videoFile);
    }
}