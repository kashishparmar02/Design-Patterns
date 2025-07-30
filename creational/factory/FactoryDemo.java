/**
 * Demo for the Factory Method pattern with NotificationDispatcher.
 */
public class FactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Demo ===");
        runDemo();
    }
    
    public static void runDemo() {
        System.out.println("=== Factory Method Demo Started ===");

        String user = "user123";
        String message = "Your order has shipped.";

        // 1) Email
        NotificationDispatcher emailDispatcher = new EmailNotificationDispatcher();
        emailDispatcher.sendNotification(user, message);

        // 2) SMS
        NotificationDispatcher smsDispatcher = new SMSNotificationDispatcher();
        smsDispatcher.sendNotification(user, message);

        // 3) Slack
        NotificationDispatcher slackDispatcher = new SlackNotificationDispatcher();
        slackDispatcher.sendNotification(user, message);

        System.out.println("---");
        System.out.println("=== Factory Method Demo Finished ===");
    }
}