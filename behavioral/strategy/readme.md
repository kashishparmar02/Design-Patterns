# **Strategy Pattern – Payment Processing System**

This project demonstrates the **Strategy pattern** through a payment processing system. The pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable, allowing the algorithm to vary independently from clients that use it.

## **Project Structure**
* **PaymentStrategy.java**: Strategy interface defining the payment algorithm contract.
* **PaymentContext.java**: Context class that uses different payment strategies.
* **PaypalPayment.java**: Concrete strategy implementing PayPal payment processing.
* **CryptoPayment.java**: Concrete strategy implementing cryptocurrency payment processing.
* **StrategyDemo.java**: Demonstrates switching between different payment strategies.

## **Implementation Components**

### **Strategy Interface (PaymentStrategy)**
- **Defines algorithm contract** with `pay()` method for payment processing
- **Enables algorithm interchangeability** through common interface
- **Supports multiple payment methods** with consistent interface

### **Context Class (PaymentContext)**
- **Maintains reference** to current payment strategy
- **Provides strategy switching** through `setPaymentStrategy()` method
- **Delegates payment execution** to the current strategy
- **Acts as client** that uses strategies without knowing implementation details

### **Concrete Strategies**
- **PaypalPayment**: Implements PayPal payment processing with email-based transactions
- **CryptoPayment**: Implements cryptocurrency payments with wallet address processing
- **Each strategy encapsulates** its specific payment logic and requirements

## **Strategy Selection Flow**
1. **Context Initialization**: PaymentContext created with no initial strategy
2. **Strategy Assignment**: Specific payment strategy set using `setPaymentStrategy()`
3. **Payment Execution**: Context delegates payment processing to current strategy
4. **Strategy Switching**: Different strategies can be set for different payment scenarios
5. **Algorithm Execution**: Each strategy processes payments according to its specific logic

## **Payment Methods**
* **PayPal Payments**: Uses email addresses for account identification and processing
* **Cryptocurrency Payments**: Uses wallet addresses with partial address display for security
* **Extensible Design**: New payment methods can be added by implementing PaymentStrategy interface
* **Runtime Switching**: Payment method can be changed without modifying existing code

## **Pattern Benefits**
* **Algorithm flexibility** allowing runtime selection of payment methods
* **Open/Closed Principle** enabling new strategies without modifying existing code
* **Eliminates conditional statements** by encapsulating algorithms in separate classes
* **Improves maintainability** by isolating payment logic in dedicated strategy classes
* **Supports multiple payment options** with consistent client interface

## **Running the Demo**
```bash
javac *.java
java StrategyDemo
```

The demo shows payment processing using different strategies - first with PayPal using an email address, then switching to cryptocurrency using a wallet address, demonstrating how the strategy pattern enables flexible payment method selection at runtime.
