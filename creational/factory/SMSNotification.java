/**
 * Concrete Product – SMS channel
 */
public class SMSNotification implements Notification {
    @Override
    public void notifyUser(String userId, String message) {
        System.out.println("Sending SMS to " + userId + ": " + message);
    }
}