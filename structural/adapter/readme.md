# **Adapter Pattern – Map Service Integration System**

This project demonstrates the **Adapter Design Pattern** through a food delivery system that integrates multiple map service providers. The pattern allows incompatible interfaces to work together by wrapping them in adapters.

## **Project Structure**
```
adapter/
├── target/
│   └── MapService.java                 (Target Interface)
├── adaptees/
│   ├── GoogleMapsSDK.java              (Google Maps Adaptee)
│   └── MapBoxSDK.java                  (MapBox Adaptee)
├── adapters/
│   ├── GoogleMapsAdapter.java          (Google Maps Adapter)
│   └── MapBoxAdapter.java              (MapBox Adapter)
├── client/
│   └── FoodDeliveryService.java        (Client)
├── Config.java                          (Configuration)
└── AdapterDemo.java                     (Demo)
```

## **Implementation Flow**
1. **Target interface (MapService)** defines the contract that clients expect
2. **Adaptee classes (SDKs)** have incompatible interfaces that need adaptation
3. **Adapter classes** implement the target interface and wrap the adaptees
4. **Client (FoodDeliveryService)** works with the target interface only
5. **Runtime switching** between different map providers through adapters

## **Pattern Benefits**
* **Adapter Pattern** allows integration of third-party services with incompatible APIs
* Client code remains unchanged when switching between different providers
* Easy to add new map service providers by creating new adapters
* Follows Single Responsibility Principle - each adapter handles one service
* Enables runtime provider switching for load balancing or failover

## **Key Components**

### **Target Interface (MapService)**
- `findLocation(String searchQuery)` - Search for location coordinates
- `getRouteInfo(String pickup, String destination)` - Get route information
- `getProviderName()` - Return provider identification

### **Adaptee Classes (SDKs)**
- **GoogleMapsSDK**: Simulates Google Maps API with geocoding and directions
- **MapBoxSDK**: Simulates MapBox API with location search and navigation

### **Adapter Classes**
- **GoogleMapsAdapter**: Wraps GoogleMapsSDK to conform to MapService
- **MapBoxAdapter**: Wraps MapBoxSDK to conform to MapService

### **Client (FoodDeliveryService)**
- Uses MapService interface without knowing specific implementations
- Can switch between providers at runtime
- Handles restaurant search and delivery route planning

## **Running the Demo**
```bash
# Navigate to parent directory of adapter folder
cd structural

# Compile all files
javac adapter/*.java adapter/*/*.java

# Run demo
java structural.adapter.AdapterDemo
```

The demo demonstrates:
- Initial setup with Google Maps as default provider
- Restaurant search and route planning functionality
- Error handling with invalid inputs
- Dynamic switching to MapBox provider
- Seamless operation with different map services

## **Real-World Applications**
* **Payment Gateway Integration**: Adapting different payment providers to common interface
* **Database Drivers**: JDBC adapters for different database systems
* **API Wrappers**: Adapting third-party APIs to internal interfaces
* **Legacy System Integration**: Wrapping old systems with new interfaces
* **Multi-Provider Services**: Switching between service providers seamlessly 