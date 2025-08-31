package behavioral.mediator;

/**
 * Simple Mediator Pattern Demo - Smart Home System
 * 
 * Shows how devices communicate through a mediator instead of directly
 */
public class MediatorDemo {
    public static void main(String[] args) {
        // Create the mediator
        SmartHomeController hub = new SmartHomeController();
        
        // Create devices
        SmartLight light = new SmartLight("Living Room Light", hub);
        SmartSecurity security = new SmartSecurity("Security System", hub);
        
        // Connect devices to mediator
        hub.setLight(light);
        hub.setSecurity(security);
        
        System.out.println("=== Mediator Pattern Demo ===\n");
        
        // Direct device actions
        System.out.println("1. Manual light control:");
        light.turnOn();
        light.turnOff();
        
        System.out.println("\n2. Security system automation:");
        security.arm(); // This will automatically turn off lights via mediator
        
        System.out.println("\n3. Motion detection:");
        security.detectMotion(); // This will turn on lights via mediator
       
    }
} 