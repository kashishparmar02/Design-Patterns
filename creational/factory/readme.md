# **Factory Method Pattern – Notification System**

This project demonstrates the **Factory Method** design pattern through a multi-channel notification system. The pattern allows creating notification objects without specifying their exact implementation class.

## **Project Structure**
* **Notification.java**: Interface defining the contract for all notification channels.
* **NotificationDispatcher.java**: Abstract creator class with the factory method.
* **EmailNotification.java, SMSNotification.java, SlackNotification.java**: Concrete notification implementations.
* **EmailNotificationDispatcher.java, SMSNotificationDispatcher.java, SlackNotificationDispatcher.java**: Concrete creators for each channel.
* **FactoryDemo.java**: Demonstrates the pattern with sample notifications.

## **Implementation Flow**
1. **Abstract dispatcher defines** the factory method `createNotification()`.
2. **Concrete dispatchers implement** the factory method for their specific channel.
3. **Client code calls** `sendNotification()` on any dispatcher type.
4. **Factory method creates** the appropriate notification object internally.
5. **Notification is sent** through the chosen channel with consistent interface.

## **Pattern Advantages**
* **Factory Method** eliminates tight coupling between client and concrete classes.
* Simplifies adding new notification channels without modifying existing code.
* Provides a uniform interface for all notification types.
* Follows Open/Closed Principle - open for extension, closed for modification.

## **Running the Demo**
```bash
javac *.java
java FactoryDemo
```

The demo will send the same message through Email, SMS, and Slack channels, showing how different implementations work through the same interface.