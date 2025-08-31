package behavioral.mediator;

/**
 * Concrete Mediator - handles communication between devices
 */
public class SmartHomeController implements SmartHomeHub {
    private SmartLight light;
    private SmartSecurity security;
    
    public void setLight(SmartLight light) {
        this.light = light;
    }
    
    public void setSecurity(SmartSecurity security) {
        this.security = security;
    }
    
    @Override
    public void notify(SmartDevice sender, String event) {
        System.out.println("Hub received: " + sender.getName() + " -> " + event);
        
        // Simple automation: when security is armed, turn off lights
        if (sender == security && event.equals("ARMED")) {
            light.turnOff();
        }
        
        // When security detects motion, turn on lights
        if (sender == security && event.equals("MOTION")) {
            light.turnOn();
        }
    }
} 