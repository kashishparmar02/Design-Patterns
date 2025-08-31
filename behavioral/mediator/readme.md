# **Mediator Pattern – Smart Home Automation System**

This project demonstrates the **Mediator pattern** through a smart home automation system. The pattern defines how a set of objects interact by centralizing communication through a mediator object, reducing direct dependencies between components.

## **Project Structure**
* **SmartHomeHub.java**: Mediator interface defining communication protocol between devices.
* **SmartHomeController.java**: Concrete mediator implementing smart home automation logic.
* **SmartDevice.java**: Abstract base class for all smart home devices.
* **SmartLight.java**: Concrete device for lighting control with on/off functionality.
* **SmartSecurity.java**: Concrete device for security system with arming and motion detection.
* **MediatorDemo.java**: Demonstrates device communication through the mediator.

## **Implementation Components**

### **Mediator Interface (SmartHomeHub)**
- **Defines communication protocol** with `notify()` method for device events
- **Centralizes interaction logic** between different smart devices
- **Decouples devices** from direct communication with each other

### **Concrete Mediator (SmartHomeController)**
- **Implements automation rules** for device interactions
- **Handles event routing** between connected devices
- **Manages device relationships** and coordinates responses to events

### **Device Classes**
- **SmartDevice**: Abstract base providing common device functionality
- **SmartLight**: Manages lighting state with turn on/off operations
- **SmartSecurity**: Handles security arming and motion detection events

## **Device Interaction Flow**
1. **Device Registration**: Devices register with the mediator during initialization
2. **Event Generation**: Devices generate events (ARMED, MOTION) through mediator
3. **Event Processing**: Mediator receives events and applies automation rules
4. **Device Coordination**: Mediator triggers appropriate responses in other devices
5. **State Management**: Devices maintain their own state while coordinating through mediator

## **Automation Rules**
* **Security Arming**: When security system is armed, lights automatically turn off
* **Motion Detection**: When motion is detected, lights automatically turn on
* **Centralized Control**: All device interactions go through the mediator hub
* **Loose Coupling**: Devices don't need direct references to each other

## **Pattern Benefits**
* **Reduces coupling** between interacting objects by centralizing communication
* **Simplifies object protocols** by replacing many-to-many interactions with one-to-many
* **Enables easy addition** of new devices without modifying existing ones
* **Centralizes control logic** making the system easier to understand and maintain
* **Supports complex interactions** between multiple objects in a controlled manner

## **Running the Demo**
```bash
javac *.java
java MediatorDemo
```

The demo shows manual device control, security system automation, and motion detection scenarios, demonstrating how the mediator coordinates device interactions without direct coupling between devices.
