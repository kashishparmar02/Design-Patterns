/**
 * Concrete Product – Slack channel
 */
public class SlackNotification implements Notification {
    @Override
    public void notifyUser(String userId, String message) {
        System.out.println("Sending SLACK message to " + userId + ": " + message);
    }
}