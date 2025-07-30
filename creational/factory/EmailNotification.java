/**
 * Concrete Product – Email channel
 */
public class EmailNotification implements Notification {
    @Override
    public void notifyUser(String userId, String message) {
        System.out.println("Sending EMAIL to " + userId + ": " + message);
    }
}