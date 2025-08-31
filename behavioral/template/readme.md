# **Template Method Pattern – ETL Data Processing System**

This project demonstrates the **Template Method pattern** through an ETL (Extract, Transform, Load) data processing system. The pattern defines the skeleton of an algorithm in a method, deferring some steps to subclasses, allowing subclasses to redefine certain steps without changing the algorithm's structure.

## **Project Structure**
* **DataProcessor.java**: Abstract class defining the ETL template method and algorithm structure.
* **CsvDataProcessor.java**: Concrete implementation for processing CSV data files.
* **JsonDataProcessor.java**: Concrete implementation for processing JSON data files.
* **TemplateDemo.java**: Demonstrates different data processing strategies using the template method.

## **Implementation Components**

### **Abstract Template Class (DataProcessor)**
- **Defines template method** `processData()` that orchestrates the ETL pipeline
- **Provides algorithm structure** with fixed sequence: Extract → Transform → Load
- **Declares abstract methods** for each ETL step to be implemented by subclasses
- **Manages data flow** between processing steps using protected data list

### **Concrete Implementations**
- **CsvDataProcessor**: Implements CSV-specific extraction, transformation, and loading logic
- **JsonDataProcessor**: Implements JSON-specific extraction, transformation, and loading logic
- **Each subclass customizes** the ETL steps while following the same overall algorithm

## **ETL Processing Flow**
1. **Data Initialization**: Empty data list created for processing pipeline
2. **Extract Phase**: Data extracted from source format (CSV rows or JSON objects)
3. **Transform Phase**: Data transformed according to specific business rules
4. **Load Phase**: Processed data prepared for final output or storage
5. **Result Return**: Complete processed data returned to client

## **Data Processing Variations**
* **CSV Processing**: Extracts comma-separated values, transforms to uppercase names, loads with "Processed:" prefix
* **JSON Processing**: Extracts JSON name fields, transforms by reversing names, loads with "_loaded" suffix
* **Consistent Algorithm**: Both implementations follow the same Extract-Transform-Load sequence
* **Customizable Steps**: Each step can be customized without changing the overall algorithm structure

## **Pattern Benefits**
* **Code reuse** by defining common algorithm structure in abstract class
* **Consistent processing flow** ensuring all data types follow the same ETL pipeline
* **Flexible customization** allowing subclasses to implement specific processing logic
* **Open/Closed Principle** enabling new data types without modifying existing template
* **Algorithm stability** preventing subclasses from changing the core processing sequence

## **Running the Demo**
```bash
javac *.java
java TemplateDemo
```

The demo shows ETL processing for both CSV and JSON data formats, demonstrating how the template method pattern ensures consistent processing flow while allowing customization of individual steps for different data types.
