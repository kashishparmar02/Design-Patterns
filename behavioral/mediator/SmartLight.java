package behavioral.mediator;

/**
 * Smart Light device
 */
public class SmartLight extends SmartDevice {
    private boolean isOn = false;
    
    public SmartLight(String name, SmartHomeHub hub) {
        super(name, hub);
    }
    
    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned ON");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned OFF");
    }
    
    public boolean isOn() {
        return isOn;
    }
} 