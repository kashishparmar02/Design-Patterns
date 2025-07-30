/**
 * Concrete creator that produces SMSNotification objects
 */
public class SMSNotificationDispatcher extends NotificationDispatcher {
    @Override
    protected Notification createNotification() {
        return new SMSNotification();
    }
}