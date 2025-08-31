package behavioral.mediator;

/**
 * Base class for all smart devices
 */
public abstract class SmartDevice {
    protected SmartHomeHub hub;
    protected String name;
    
    public SmartDevice(String name, SmartHomeHub hub) {
        this.name = name;
        this.hub = hub;
    }
    
    public String getName() {
        return name;
    }
} 