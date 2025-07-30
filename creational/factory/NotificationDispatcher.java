/**
 * Abstract creator class that declares the factory method.
 */
public abstract class NotificationDispatcher {
    /**
     * Factory method to be implemented by subclasses
     * @return a Notification instance
     */
    protected abstract Notification createNotification();

    /**
     * Common business logic using the factory method
     * @param userId the user to notify
     * @param message the message to send
     */
    public void sendNotification(String userId, String message) {
        Notification notification = createNotification();
        notification.notifyUser(userId, message);
    }
}