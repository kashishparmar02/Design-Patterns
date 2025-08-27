# **Flyweight Pattern – Game Army Rendering System**

This project demonstrates the **Flyweight Design Pattern** through a game army rendering system that efficiently manages thousands of soldier objects. The pattern minimizes memory usage by sharing common data (intrinsic state) among multiple objects while maintaining individual identity through unique data (extrinsic state).

## **Project Structure**
```
flyweight/
├── Soldier.java                        (Flyweight Interface)
├── ConcreteSoldier.java                (Concrete Flyweight)
├── SoldierFactory.java                 (Flyweight Factory)
├── Game.java                           (Client)
└── readme.md                           (Documentation)
```

## **Implementation Flow**
1. **Flyweight interface (Soldier)** defines contract for shared objects with extrinsic state parameters
2. **Concrete flyweight (ConcreteSoldier)** stores intrinsic state and accepts extrinsic state via methods
3. **Flyweight factory (SoldierFactory)** manages object pooling and ensures sharing of flyweight instances
4. **Client (Game)** requests flyweights from factory and manages extrinsic state externally
5. **Memory optimization** achieved by sharing expensive objects across thousands of logical instances

## **Pattern Benefits**
* **Flyweight Pattern** dramatically reduces memory usage by sharing common object data
* Separates intrinsic state (shared) from extrinsic state (unique) for optimal memory efficiency
* Factory manages object lifecycle and ensures proper sharing of flyweight instances
* Enables handling of massive object collections that would otherwise exceed memory limits
* Provides transparent interface - client code works with flyweights like regular objects

## **Key Components**

### **Flyweight Interface (Soldier)**
- `render(int x, int y, int currentHealth)` - Render soldier using intrinsic state and passed extrinsic state
- **Extrinsic state parameters**: Position coordinates and health passed from client

### **Concrete Flyweight (ConcreteSoldier)**
- **ConcreteSoldier**: Contains expensive intrinsic state (3D model, textures)
- **Intrinsic State** (shared among all instances):
  - `model3D` - 3D model file path ("RiflemanModel.obj")
  - `texture` - Texture file path ("rifleman_texture.png")
- **Heavy construction**: 2-second loading simulation for expensive resources
- **No extrinsic state storage** - accepts unique data as method parameters

### **Flyweight Factory (SoldierFactory)**
- **SoldierFactory**: Manages flyweight object pool using HashMap cache
- **Object sharing**: Returns existing instances when available, creates new ones only when needed
- **Cache management**: Tracks created objects and provides statistics
- **Memory optimization**: Ensures only one heavy object per soldier type

### **Client (Game)**
- Uses SoldierFactory to obtain shared flyweight objects
- **Manages extrinsic state**: Generates unique position and health for each soldier
- **Demonstrates efficiency**: Shows dramatic difference between logical objects and actual memory usage
- **Performance measurement**: Tracks object creation statistics

## **Running the Demo**
```bash
# Navigate to parent directory of flyweight folder
cd structural

# Compile all files
javac flyweight/*.java

# Run demo
java structural.flyweight.Game
```

The demo demonstrates:
- **First soldier request**: Heavy object creation with 2-second loading delay
- **Subsequent requests**: Instant retrieval from factory cache
- **Unique rendering**: Each soldier rendered at different position with different health
- **Memory efficiency**: 10 soldiers rendered using only 1 actual heavy object
- **Scalability**: Pattern works identically with 10 or 10,000 soldiers

## **State Separation**

### **Intrinsic State (Stored in Flyweight)**
- **3D Model**: Expensive geometry data shared by all soldiers of same type
- **Textures**: Image data used for rendering appearance
- **Heavy Resources**: Loaded once during object construction

### **Extrinsic State (Passed as Parameters)**
- **Position**: X/Y coordinates unique to each soldier instance
- **Health**: Current hit points varying per individual soldier
- **Dynamic Data**: Changes frequently during game execution

## **Memory Efficiency Analysis**
- **Without Flyweight**: 10,000 soldiers × 1 heavy object each = 10,000 heavy objects in memory
- **With Flyweight**: 10,000 soldiers × 1 shared object = 1 heavy object + 10,000 lightweight references
- **Memory Savings**: 99.99% reduction in heavy object instances
- **Performance Gain**: Expensive loading operations reduced by factor of 10,000

## **Real-World Applications**
* **Game Development**: Managing sprites, textures, and 3D models for large armies or particle systems
* **Text Editors**: Sharing character formatting objects across documents with millions of characters
* **Web Browsers**: Sharing CSS style objects among thousands of DOM elements
* **Graphics Systems**: Managing fonts, colors, and drawing primitives in rendering engines
* **Database Systems**: Sharing metadata objects across multiple result sets
* **UI Frameworks**: Sharing widget templates and styling information across interface elements 