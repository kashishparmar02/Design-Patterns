# **Observer Pattern – Stock Market Notification System**

This project demonstrates the **Observer pattern** through a stock market notification system. The pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

## **Project Structure**
* **Observer.java**: Observer interface defining the update method for notifications.
* **Stock.java**: Subject class that maintains a list of observers and notifies them of changes.
* **Trader.java**: Concrete observer that receives and displays stock price updates.
* **ObserverDemo.java**: Demonstrates the pattern with multiple traders observing stock price changes.

## **Implementation Components**

### **Subject (Stock)**
- **Maintains observer list** for tracking registered observers
- **Provides registration methods** for adding and removing observers
- **Notifies all observers** when stock price changes occur
- **Manages state changes** and coordinates observer updates

### **Observer Interface (Observer)**
- **Defines update contract** that all observers must implement
- **Specifies notification method** for receiving state change notifications
- **Enables polymorphic observer handling** through common interface

### **Concrete Observer (Trader)**
- **Implements observer interface** to receive stock price notifications
- **Displays personalized updates** with trader name and stock information
- **Maintains individual identity** while responding to shared notifications

## **Notification Flow**
1. **Observer Registration**: Traders register with the stock to receive updates
2. **Price Change**: Stock price is updated through `setPrice()` method
3. **Observer Notification**: Stock notifies all registered observers of the change
4. **Update Processing**: Each observer processes the notification according to its implementation
5. **Response Display**: Observers display personalized responses to the price change

## **Pattern Benefits**
* **Loose coupling** between subject and observers through abstract interfaces
* **Dynamic relationships** allowing observers to be added or removed at runtime
* **Broadcast communication** enabling one-to-many notifications efficiently
* **Extensible design** supporting new observer types without modifying existing code
* **Event-driven architecture** supporting reactive programming patterns

## **Running the Demo**
```bash
javac *.java
java ObserverDemo
```

The demo shows multiple traders (John and Alice) observing stock price changes for different stocks (AAPL, GOOGL, MSFT), demonstrating how the observer pattern enables real-time notifications to multiple subscribers when stock prices change.
