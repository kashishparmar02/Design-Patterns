package behavioral.mediator;

/**
 * Mediator interface for smart home device communication
 */
public interface SmartHomeHub {
    void notify(SmartDevice sender, String event);
} 