# **Facade Pattern – Multisig Wallet System**

This project demonstrates the **Facade Design Pattern** through a multi-signature wallet system that simplifies complex blockchain operations. The pattern provides a unified interface to a set of interfaces in a subsystem, making it easier to use.

## **Project Structure**
```
facade/
├── facade/
│   └── MultisigWalletFacade.java       (Facade)
├── subsystems/
│   ├── Transaction.java                (Subsystem Component)
│   ├── SignatureService.java           (Subsystem Component)
│   └── BlockchainService.java          (Subsystem Component)
└── Main.java                           (Client/Demo)
```

## **Pattern Overview**

The Facade pattern provides a simplified interface to a complex subsystem. In this implementation:
- **MultisigWalletFacade** acts as the facade, hiding the complexity of blockchain operations
- **Subsystems** (Transaction, SignatureService, BlockchainService) handle the intricate details
- **Client** interacts only with the facade, completely unaware of the underlying complexity
- **Simplified workflow** for multi-signature transaction management

## **Implementation Flow**
1. **Facade (MultisigWalletFacade)** provides a simple interface for wallet operations
2. **Subsystem Components** handle specific aspects of the blockchain system
3. **Client (Main)** uses only the facade interface without knowing subsystem details
4. **Complex operations** are orchestrated by the facade behind the scenes
5. **Automatic workflow** manages the entire transaction lifecycle

## **Key Components**

### **Facade Layer**

#### **MultisigWalletFacade**
- **Primary Interface**: Provides simplified methods for wallet operations
- **Orchestration**: Coordinates between different subsystem components
- **State Management**: Maintains transaction registry and status tracking
- **Methods**:
  - `createTransaction()` - Creates new transaction proposals
  - `approveTransaction()` - Handles signature collection and approval
  - `checkTransactionStatus()` - Provides transaction status information

### **Subsystem Components**

#### **Transaction**
- **Data Model**: Represents multi-signature transaction proposals
- **State Tracking**: Manages signature collection and approval status
- **Validation**: Ensures transaction integrity and completion criteria
- **Methods**: `addSignature()`, `isApproved()`, getters for transaction details

#### **SignatureService**
- **Cryptographic Operations**: Handles digital signature creation and validation
- **Security Layer**: Manages the complex cryptographic processes
- **Integration**: Works with Transaction objects to add signatures

#### **BlockchainService**
- **Network Communication**: Handles broadcasting to blockchain networks
- **Transaction Finalization**: Manages the final step of transaction processing
- **External Integration**: Interfaces with blockchain infrastructure

## **Pattern Benefits**

### **Simplified Interface**
- Complex multi-signature workflow reduced to simple method calls
- Client code doesn't need to understand blockchain intricacies
- Easy to use for developers unfamiliar with blockchain technology

### **Decoupling**
- Client is completely decoupled from subsystem implementations
- Changes to subsystem components don't affect client code
- Subsystems can be modified or replaced without client impact

### **Encapsulation**
- Complex operations are hidden behind a simple interface
- Internal workflow orchestration is abstracted away
- Error handling and validation are centralized in the facade

### **Maintainability**
- Single point of control for complex operations
- Easier to debug and modify system behavior
- Clear separation between client interface and implementation details

## **Usage Examples**

### **Creating a Transaction**
```java
MultisigWalletFacade wallet = new MultisigWalletFacade();
wallet.createTransaction("tx-001", "0xRecipientAddress", 50.0, 3);
```

### **Approving Transactions**
```java
wallet.approveTransaction("tx-001", "User-A");
wallet.approveTransaction("tx-001", "User-B");
wallet.approveTransaction("tx-001", "User-C"); // Triggers automatic broadcast
```

### **Checking Status**
```java
wallet.checkTransactionStatus("tx-001");
```

## **Running the Demo**

### **Compile**
```bash
# Navigate to project root
cd structural

# Compile all files
javac facade/*.java facade/facade/*.java facade/subsystems/*.java
```

### **Run**
```bash
java structural.facade.Main
```

## **Real-World Applications**

### **Financial Systems**
- **Banking APIs**: Simplifying complex banking operations for mobile apps
- **Payment Gateways**: Unified interface for multiple payment processors
- **Trading Platforms**: Simplified interface for complex trading operations

### **System Integration**
- **Database Facades**: Hiding complexity of multiple database systems
- **API Wrappers**: Simplifying third-party service integrations
- **Legacy System Integration**: Providing modern interfaces to old systems

### **User Interfaces**
- **GUI Frameworks**: Simplifying complex UI operations
- **Game Engines**: Hiding rendering and physics complexity
- **Web Frameworks**: Abstracting HTTP and routing complexity

### **Enterprise Applications**
- **CRM Systems**: Simplifying customer relationship management
- **ERP Integration**: Unified interface for enterprise resource planning
- **Workflow Management**: Orchestrating complex business processes
