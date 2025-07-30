
/**
 * The Notification interface – all channels implement this.
 */
public interface Notification {
    void notifyUser(String userId, String message);
}