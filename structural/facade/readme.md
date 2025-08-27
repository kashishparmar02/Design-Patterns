# **Facade Pattern – Shop Management System**

This project demonstrates the **Facade Design Pattern** through a shop management system that simplifies complex inventory operations. The pattern provides a unified interface to a set of interfaces in a subsystem, making the subsystem easier to use by hiding its complexity behind a simple facade.

## **Project Structure**
```
facade/
├── ShopkeeperFacade.java               (Facade)
├── InventorySystem.java                (Subsystem)
├── StockItem.java                      (Subsystem Component)
├── ShopManagerClient.java              (Client)
└── readme.md                           (Documentation)
```

## **Implementation Flow**
1. **Client (ShopManagerClient)** interacts only with the facade, never directly with subsystems
2. **Facade (ShopkeeperFacade)** provides simple, business-oriented methods for complex operations
3. **Subsystem (InventorySystem)** contains the complex logic for inventory management
4. **Data Model (StockItem)** represents individual items with count and location information
5. **Coordination** facade orchestrates multiple subsystem calls to complete high-level operations

## **Pattern Benefits**
* **Facade Pattern** simplifies client interaction with complex subsystems
* Provides a single entry point for multiple related operations
* Hides subsystem complexity behind a clean, business-friendly interface
* Reduces coupling between clients and subsystem components
* Makes the subsystem easier to use and understand for common use cases

## **Key Components**

### **Facade (ShopkeeperFacade)**
- `findAndGetItem(String itemName)` - Complete customer purchase workflow
- `addNewItemToStock(String itemName, int initialCount, String location)` - Add new products
- `updateItemStock(String itemName, int newCount)` - Update existing stock levels
- **Coordinates subsystem operations** and provides user-friendly feedback

### **Subsystem (InventorySystem)**
- **InventorySystem**: Complex inventory management with fine-grained operations
- **Core Operations**:
  - `checkStock(String itemName)` - Verify item availability
  - `getItemLocation(String itemName)` - Find item storage location
  - `deductStock(String itemName)` - Remove item from inventory
  - `addNewItem()` - Create new inventory entries
  - `updateStock()` - Modify existing stock counts

### **Data Model (StockItem)**
- **StockItem**: Encapsulates item information (count, location)
- **Immutable location** once item is created
- **Mutable count** for stock level management

### **Client (ShopManagerClient)**
- Uses only the facade interface for all shop operations
- **No direct subsystem access** - maintains clean separation
- **Simple method calls** for complex business operations
- **Demonstrates various scenarios**: purchases, stock management, new products

## **Running the Demo**
```bash
# Navigate to parent directory of facade folder
cd structural

# Compile all files
javac facade/*.java

# Run demo
java structural.facade.ShopManagerClient
```

The demo demonstrates:
- **Customer purchase**: Stock checking → location finding → inventory deduction
- **Out of stock handling**: Graceful failure when items unavailable
- **New product addition**: Adding items with initial stock and location
- **Stock updates**: Modifying quantities for existing products
- **Complex coordination**: Multiple subsystem operations per facade call

## **Operation Complexity Comparison**

### **Without Facade (Direct Subsystem Access)**
```java
// Complex client code required:
InventorySystem inventory = new InventorySystem();
if (inventory.checkStock("Parker Pen")) {
    String location = inventory.getItemLocation("Parker Pen");
    System.out.println("Getting item from: " + location);
    inventory.deductStock("Parker Pen");
    System.out.println("Purchase complete");
} else {
    System.out.println("Item out of stock");
}
```

### **With Facade (Simplified Interface)**
```java
// Simple client code:
ShopkeeperFacade shopkeeper = new ShopkeeperFacade();
shopkeeper.findAndGetItem("Parker Pen");  // Handles all complexity internally
```

## **Subsystem Coordination**
Each facade method orchestrates multiple subsystem operations:

### **Customer Purchase Flow**
1. **Stock Check**: Verify item availability in inventory
2. **Location Lookup**: Find where item is stored in shop
3. **User Feedback**: Inform about item retrieval process
4. **Inventory Update**: Deduct item from stock count
5. **Completion**: Confirm successful purchase

### **Stock Management Flow**
1. **Validation**: Check if operations are valid
2. **Inventory Update**: Modify stock levels or add new items
3. **Feedback**: Provide confirmation of successful operations
4. **Error Handling**: Graceful handling of invalid operations

## **Pattern Advantages Demonstrated**
* **Simplified Client Code**: One method call replaces multiple subsystem interactions
* **Business-Oriented Interface**: Methods named for business operations, not technical details
* **Error Handling**: Facade manages edge cases and provides user-friendly messages
* **Subsystem Evolution**: Inventory system can change without affecting clients
* **Reduced Coupling**: Clients depend only on facade, not on subsystem classes

## **Real-World Applications**
* **E-commerce Systems**: Order processing facades hiding payment, inventory, and shipping subsystems
* **Banking APIs**: Account management facades simplifying complex financial operations
* **Media Players**: Playback controls hiding complex audio/video processing subsystems
* **Database Frameworks**: ORM facades simplifying complex SQL operations and connection management
* **Web Service APIs**: REST facades providing simple interfaces to complex business logic
* **Operating System APIs**: System call facades hiding low-level hardware and kernel operations 