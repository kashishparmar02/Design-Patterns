package behavioral.command.invoker;

import java.util.concurrent.BlockingQueue;

import behavioral.command.command.Command;

/**
 * The Invoker class. It runs in a separate thread and pulls commands
 * from a queue to execute them. It doesn't know the concrete command type.
 */
public class Worker extends Thread {
    private final BlockingQueue<Command> commandQueue;
    private volatile boolean isRunning = true;

    public Worker(BlockingQueue<Command> commandQueue) {
        this.commandQueue = commandQueue;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                // Take a command from the queue and execute it.
                Command command = commandQueue.take();
                command.execute();
            } catch (InterruptedException e) {
                if (isRunning) { // Only log if not shutting down
                    Thread.currentThread().interrupt();
                    System.err.println("Worker thread interrupted.");
                }
            }
        }
    }

    public void shutdown() {
        isRunning = false;
        this.interrupt(); // Interrupt the thread if it's waiting on the queue.
    }
}