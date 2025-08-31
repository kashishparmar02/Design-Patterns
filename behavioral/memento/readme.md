# **Memento Pattern – Game Save System**

This project demonstrates the **Memento pattern** through a game save system. The pattern provides the ability to restore an object to its previous state by capturing and externalizing an object's internal state without violating encapsulation.

## **Project Structure**
* **GamePlayer.java**: Originator class that creates and uses mementos to save/restore state.
* **PlayerMemento.java**: Memento class storing the player's health and score state.
* **GameCaretaker.java**: Caretaker class responsible for storing and managing mementos.
* **MementoDemo.java**: Demonstrates the save and restore functionality with state changes.

## **Implementation Components**

### **Originator (GamePlayer)**
- **Manages internal state** including health and score values
- **Creates mementos** through `save()` method to capture current state
- **Restores state** through `restore()` method using provided memento
- **Provides state modification** methods like `takeDamage()` and `addScore()`

### **Memento (PlayerMemento)**
- **Stores snapshot** of player's health and score at a specific point in time
- **Immutable object** ensuring state cannot be modified after creation
- **Provides access methods** for retrieving stored state values
- **Encapsulates state data** without exposing internal structure

### **Caretaker (GameCaretaker)**
- **Manages memento storage** without knowing memento's internal structure
- **Provides save functionality** by requesting memento from originator
- **Handles restore operations** by passing stored memento back to originator
- **Acts as intermediary** between originator and memento storage

## **Save and Restore Flow**
1. **Initial State**: GamePlayer starts with initial health and score values
2. **State Changes**: Player takes damage, gains score, or other modifications occur
3. **Save Process**: Caretaker requests memento from originator to capture current state
4. **Memento Creation**: Originator creates memento with current health and score
5. **Memento Storage**: Caretaker stores memento without accessing its contents
6. **Restore Process**: Caretaker provides stored memento back to originator
7. **State Restoration**: Originator restores its state using memento data

## **Pattern Benefits**
* **Preserves encapsulation** by not exposing object's internal state structure
* **Enables undo functionality** by allowing objects to return to previous states
* **Supports checkpoint systems** for saving progress at specific points
* **Provides state management** without tight coupling between objects
* **Allows external storage** of object state for persistence or recovery

## **Running the Demo**
```bash
javac *.java
java MementoDemo
```

The demo shows the complete save and restore cycle, demonstrating how a game player's state can be saved before changes and restored afterward, effectively implementing an undo mechanism for game state management.
