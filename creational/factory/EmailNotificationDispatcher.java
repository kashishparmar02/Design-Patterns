/**
 * Concrete creator that produces EmailNotification objects
 */
public class EmailNotificationDispatcher extends NotificationDispatcher {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}