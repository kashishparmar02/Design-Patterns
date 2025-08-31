package behavioral.command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import behavioral.command.command.Command;
import behavioral.command.command.ProcessVideoCommand;
import behavioral.command.invoker.Worker;
import behavioral.command.receiver.VideoProcessingService;

/**
 * The Client. It creates and configures Concrete Commands. It then adds them
 * to the invoker's queue. This class simulates a web server.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        // The shared queue that decouples the web server from the worker.
        BlockingQueue<Command> taskQueue = new LinkedBlockingQueue<>();

        // The Receiver that performs the actual work.
        VideoProcessingService videoProcessor = new VideoProcessingService();

        // The Invoker that processes tasks from the queue in the background.
        Worker worker = new Worker(taskQueue);
        worker.start();

        System.out.println("Web server is running. Simulating video uploads...");

        // Simulate a user uploading a video. A command is created and queued.
        taskQueue.put(new ProcessVideoCommand(videoProcessor, "summer_vacation.mp4"));
        System.out.println("UPLOADED: 'summer_vacation.mp4'. Task added to queue.");

        // The web server remains responsive and can accept another upload immediately.
        taskQueue.put(new ProcessVideoCommand(videoProcessor, "birthday_party.mov"));
        System.out.println("UPLOADED: 'birthday_party.mov'. Task added to queue.");
        
        System.out.println("\nAll uploads finished. The server is free, tasks are processing in the background.");

        // Wait a moment before shutting down to allow tasks to complete.
        TimeUnit.SECONDS.sleep(7);
        System.out.println("\nShutting down the system.");
        worker.shutdown();
    }
}
