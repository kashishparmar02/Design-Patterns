# **Decorator Pattern – Weapon Customization System**

This project demonstrates the **Decorator Design Pattern** through a weapon customization system that allows dynamic addition of attachments to weapons. The pattern lets you attach new behaviors to objects by placing them inside special wrapper objects that contain the behaviors.

## **Project Structure**
```
decorator/
├── Weapon.java                           (Component Interface)
├── AssaultRifle.java                     (Concrete Component)
├── WeaponAttachmentDecorator.java        (Base Decorator)
├── SilencerDecorator.java               (Concrete Decorator)
├── ScopeDecorator.java                  (Concrete Decorator)
├── MuzzleDecorator.java                 (Concrete Decorator)
├── SkinDecorator.java                   (Concrete Decorator)
└── Main.java                            (Client/Demo)
```

## **Implementation Flow**
1. **Component Interface (Weapon)** defines the contract for all weapons and attachments
2. **Concrete Component (AssaultRifle)** provides the base weapon implementation
3. **Base Decorator (WeaponAttachmentDecorator)** provides common decorator functionality
4. **Concrete Decorators** add specific attachment behaviors
5. **Client** can combine any attachments with any weapon at runtime

## **Pattern Benefits**
* **Decorator Pattern** allows behavior to be added to objects dynamically without altering their structure
* Same base weapon can have multiple different configurations without creating separate classes
* Easy to add new attachment types without changing existing code
* Follows Open/Closed Principle - open for extension, closed for modification
* Enables flexible combinations of attachments in any order

## **Key Components**

### **Component Interface (Weapon)**
- `fire()` - Describes the firing action of the weapon
- `getDescription()` - Provides full description of weapon and attachments
- `getDamage()` - Calculates total damage value
- `getAccuracy()` - Calculates total accuracy value

### **Concrete Component (AssaultRifle)**
- **AssaultRifle**: Base weapon with core stats (45.0 damage, 75.0 accuracy)
- Provides foundation functionality that decorators will enhance

### **Base Decorator (WeaponAttachmentDecorator)**
- **WeaponAttachmentDecorator**: Abstract base class for all weapon attachments
- Holds reference to wrapped weapon object and provides default delegation

### **Concrete Decorators**
- **SilencerDecorator**: Reduces damage (-3.0) and changes fire sound to silenced
- **ScopeDecorator**: Increases accuracy (+15.0) for better targeting
- **MuzzleDecorator**: Increases damage (+5.0) but reduces accuracy (-2.0)
- **SkinDecorator**: Cosmetic only, adds custom skin name to description

### **Client Class (Main)**
- **Main**: Demonstrates different weapon configurations with various attachment combinations
- Shows stealth loadout (silencer + scope + skin) and heavy hitter loadout (muzzle + scope + skin)

## **Usage Examples**

### **Basic Weapon Setup**
```java
Weapon myRifle = new AssaultRifle();
```

### **Stealth Configuration**
```java
Weapon stealthRifle = new SkinDecorator(
    new ScopeDecorator(
        new SilencerDecorator(myRifle)
    ), "Crimson Web"
);
```

### **Heavy Damage Configuration**
```java
Weapon heavyRifle = new SkinDecorator(
    new MuzzleDecorator(
        new ScopeDecorator(myRifle)
    ), "Gold Rush"
);
```

## **How to Run**

### **Compile the Code**
```bash
javac -d bin structural/decorator/*.java
```

### **Execute the Demo**
```bash
java -cp bin structural.decorator.Main
```

## **Expected Output**
The demo shows three weapon configurations:
1. **Base Weapon**: Standard assault rifle stats
2. **Stealth Loadout**: Silencer reduces damage but scope increases accuracy
3. **Heavy Hitter Loadout**: Muzzle brake increases damage, scope increases accuracy

## **Real-World Applications**

### **Gaming Industry**
- Weapon customization systems in FPS games (Call of Duty, Counter-Strike)
- Vehicle modification systems in racing games
- Skill tree enhancements in action games

### **Software Development**
- HTTP middleware chains (Express.js, ASP.NET Core)
- Stream processing pipelines with filters and transformations
- UI component enhancement (adding scrollbars, borders, animations)
- Plugin architecture for adding features to core applications

### **Enterprise Applications**
- Adding cross-cutting concerns (logging, security, caching) to business services
- Data validation and transformation layers
- Request/response processing in web services
- Feature toggles and A/B testing frameworks 