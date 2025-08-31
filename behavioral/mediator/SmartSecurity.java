package behavioral.mediator;

/**
 * Smart Security System
 */
public class SmartSecurity extends SmartDevice {
    private boolean isArmed = false;
    
    public SmartSecurity(String name, SmartHomeHub hub) {
        super(name, hub);
    }
    
    public void arm() {
        isArmed = true;
        System.out.println(name + " is ARMED");
        hub.notify(this, "ARMED");
    }
    
    public void detectMotion() {
        System.out.println(name + " detected motion!");
        hub.notify(this, "MOTION");
    }
    
    public boolean isArmed() {
        return isArmed;
    }
} 