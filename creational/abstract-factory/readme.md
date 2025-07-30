# **Abstract Factory Pattern – Cloud Infrastructure System**

This project demonstrates the **Abstract Factory Pattern** through a cloud infrastructure provisioning system. The pattern allows creating families of related cloud resources without specifying their concrete implementations.

## **Project Structure**
```
abstract-factory/
├── factory/
│   ├── CloudFactory.java               (Abstract Factory)
│   ├── AWSFactory.java                 (Concrete Factory)
│   └── AzureFactory.java               (Concrete Factory)
├── product/
│   ├── ComputeInstance.java            (Abstract Product)
│   ├── Database.java                   (Abstract Product)
│   ├── Storage.java                    (Abstract Product)
│   ├── aws/
│   │   ├── EC2Instance.java            (AWS Concrete Product)
│   │   ├── RDSDatabase.java            (AWS Concrete Product)
│   │   └── S3Storage.java              (AWS Concrete Product)
│   └── azure/
│       ├── AzureVM.java                (Azure Concrete Product)
│       ├── AzureSqlDatabase.java       (Azure Concrete Product)
│       └── AzureBlobStorage.java       (Azure Concrete Product)
├── client/
│   └── CloudInfrastructureManager.java (Client)
└── AbstractFactoryDemo.java            (Demo)
```

## **Factory Creation Process**
1. **Abstract factory defines** methods for creating each product type in the family
2. **Concrete factories implement** the abstract factory for specific cloud providers
3. **Client requests infrastructure** through factory interface without knowing specifics
4. **Factory creates compatible products** ensuring all components work together
5. **Infrastructure components deployed** with guaranteed provider consistency

## **Pattern Benefits**
* **Abstract Factory Pattern** ensures compatibility between products from same family
* Eliminates mixing incompatible cloud components (AWS server + Azure database)
* Easy switching between entire cloud provider stacks with single configuration change
* Centralizes cloud-specific creation logic in dedicated factory classes
* Supports adding new cloud providers without modifying existing client code

## **Running the Demo**
```bash
# Navigate to parent directory of abstract-factory folder  

# Compile all files
javac *.java

# Run demo
java AbstractFactoryDemo
```

The demo provisions identical infrastructure on both AWS and Azure platforms, showing how the same client code works with different product families through the abstract factory interface.