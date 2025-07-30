/**
 * Concrete creator that produces SlackNotification objects
 */
public class SlackNotificationDispatcher extends NotificationDispatcher {
    @Override
    protected Notification createNotification() {
        return new SlackNotification();
    }
}