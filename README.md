# Design Patterns in Java

This repository contains implementations of common design patterns in Java, organized into three categories: **Creational**, **Behavioral**, and **Structural**. Each pattern is implemented as a standalone module with clear folder structures and examples to demonstrate its usage.

The project aims to serve as a learning resource for developers to understand and apply design patterns in real-world applications.

---

## Table of Contents

* [Project Structure](#project-structure)
* [Design Patterns Included](#design-patterns-included)

  * [Creational Patterns](#creational-patterns)
  * [Behavioral Patterns](#behavioral-patterns)
  * [Structural Patterns](#structural-patterns)
* [Prerequisites](#prerequisites)
* [Setup Instructions](#setup-instructions)
* [Usage](#usage)
* [Contributing](#contributing)

---

## Project Structure

The repository is organized as follows:

```
design-patterns/
├── creational/
│   ├── abstract-factory/
│   ├── factory/
│   ├── singleton/
│   ├── builder/
│   └── prototype/
├── behavioral/
│   ├── template-method/
│   ├── mediator/
│   ├── chain-of-responsibility/
│   ├── observer/
│   ├── strategy/
│   ├── command/
│   ├── state/
│   ├── visitor/
│   ├── interpreter/
│   ├── iterator/
│   └── memento/
├── structural/
│   ├── adapter/
│   ├── composite/
│   ├── proxy/
│   ├── flyweight/
│   ├── facade/
│   ├── bridge/
│   └── decorator/
├── .gitignore
└── README.md
```

* `creational/`: Patterns that deal with object creation mechanisms.
* `behavioral/`: Patterns that focus on communication between objects.
* `structural/`: Patterns that simplify relationships between objects.
* Each pattern folder (e.g., `abstract-factory/`) contains subfolders like `client/`, `factory/`, and `product/` (where applicable) to organize the implementation logically.

---

## Design Patterns Included

### Creational Patterns

* **Singleton**: Ensures a class has only one instance and provides a global point of access.
* **Factory**: Defines an interface for creating objects, letting subclasses decide which class to instantiate.
* **Abstract Factory**: Creates families of related or dependent objects without specifying their concrete classes.
* **Builder**: Separates the construction of a complex object from its representation.
* **Prototype**: Creates new objects by copying an existing instance (prototype).

### Behavioral Patterns

* **Template Method**: Defines the skeleton of an algorithm, allowing subclasses to override specific steps.
* **Mediator**: Simplifies communication between objects by introducing a mediator.
* **Chain of Responsibility**: Passes a request along a chain of handlers.
* **Observer**: Defines a one-to-many dependency, notifying multiple objects of state changes.
* **Strategy**: Defines a family of interchangeable algorithms.
* **Command**: Encapsulates a request as an object, allowing parameterization and queuing.
* **State**: Allows an object to alter its behavior when its internal state changes.
* **Visitor**: Separates an algorithm from an object structure it operates on.
* **Interpreter**: Defines a grammar for interpreting sentences in a language.
* **Iterator**: Provides a way to access elements of an aggregate object sequentially.
* **Memento**: Captures and restores an object’s internal state without violating encapsulation.

### Structural Patterns

* **Adapter**: Converts the interface of a class into another interface clients expect.
* **Composite**: Composes objects into tree structures to represent part-whole hierarchies.
* **Proxy**: Provides a surrogate or placeholder for another object to control access.
* **Flyweight**: Reduces memory usage by sharing as much data as possible with similar objects.
* **Facade**: Provides a simplified interface to a complex subsystem.
* **Bridge**: Decouples an abstraction from its implementation, allowing them to vary independently.
* **Decorator**: Dynamically adds responsibilities to objects in a flexible way.

---

## Prerequisites

* **Java**: JDK 8 or higher
* **Git**: To clone and contribute to the repository
* *(Optional)*: An IDE like IntelliJ IDEA or Eclipse for easier navigation and compilation

---

## Setup Instructions

### Clone the Repository

```bash
git clone https://github.com/kashishparmar02/Design-Patterns.git
cd design-patterns
```

### Compile the Code

Navigate to the pattern you want to run. For example, for Abstract Factory:

```bash
cd creational/abstract-factory
javac client/*.java factory/*.java product/*.java
```

### Run the Code

```bash
java AbstractFactoryDemo
```

---

## Usage

Each pattern folder contains a self-contained implementation with:

* **Client Code**: Demonstrates how to use the pattern
* **Interfaces / Abstract Classes**: Define the contracts
* **Concrete Implementations**: Provide specific implementations (e.g., `AWS`, `Azure` in Abstract Factory)

To explore a pattern:

1. Navigate to its folder (e.g., `creational/abstract-factory`)
2. Review the code in `client/`, `factory/`, and `product/`
3. Compile and run as shown above

---

## Contributing

Contributions are welcome! To add a new pattern or improve an existing one:

1. **Fork the repository**
2. **Create a branch** for your changes:

```bash
git checkout -b add-behavioral-observer
```

3. **Add or modify files** in the appropriate folder (e.g., `behavioral/observer`)

   * Ensure package declarations match the folder structure (e.g., `package behavioral.observer;`)

4. **Test your code**:

```bash
javac behavioral/observer/**/*.java
java behavioral.observer.Main
```

5. **Commit and push**:

```bash
git add .
git commit -m "Added observer pattern implementation"
git push origin add-behavioral-observer
```

6. **Submit a pull request** on GitHub.

---

