# **Proxy Pattern – CDN Video Streaming System**

This project demonstrates the **Proxy Design Pattern** through a Content Delivery Network (CDN) video streaming system. The pattern provides a placeholder or surrogate for another object to control access to it, adding caching functionality for performance optimization.

## **Project Structure**
```
proxy/
├── Video.java                          (Subject Interface)
├── MainServer.java                     (Real Subject)
├── CDNCacheProxy.java                  (Proxy)
├── Client.java                         (Client)
└── readme.md                           (Documentation)
```

## **Implementation Flow**
1. **Subject interface (Video)** defines the contract for both real subject and proxy
2. **Real subject (MainServer)** contains the actual expensive video loading logic
3. **Proxy (CDNCacheProxy)** implements the same interface and controls access to MainServer
4. **Client** works with the proxy through the common interface, unaware of the proxy
5. **Caching mechanism** stores results for subsequent requests, improving performance

## **Pattern Benefits**
* **Proxy Pattern** provides controlled access to expensive resources
* Adds caching functionality without modifying the original server code
* Client code remains unchanged - works transparently with proxy
* Follows Single Responsibility Principle - proxy handles caching, server handles loading
* Enables performance optimization through lazy loading and result caching

## **Key Components**

### **Subject Interface (Video)**
- `getVideoContent()` - Retrieve video content as byte array
- `getVideoId()` - Get unique video identifier

### **Real Subject (MainServer)**
- **MainServer**: Contains expensive video loading logic with 2-second network delay
- Implements lazy loading - content only fetched when first requested
- Simulates real-world scenario of slow network operations

### **Proxy (CDNCacheProxy)**
- **CDNCacheProxy**: Wraps MainServer and adds caching functionality
- Checks local cache before delegating to real server
- Stores fetched content for future requests
- Provides transparent interface identical to MainServer

### **Client**
- Uses Video interface without knowing whether it's working with proxy or real server
- Measures and displays performance differences between cached and uncached requests
- Demonstrates the proxy pattern's performance benefits

## **Running the Demo**
```bash
# Navigate to parent directory of proxy folder
cd structural

# Compile all files
javac proxy/*.java

# Run demo
java structural.proxy.Client
```

The demo demonstrates:
- **First request**: ~2000ms - Video fetched from remote Origin Server (slow)
- **Second request**: ~0ms - Same video served instantly from CDN Cache (fast)
- **Transparent operation**: Client unaware of caching mechanism
- **Performance optimization**: Dramatic speed improvement for repeated requests

## **Proxy Pattern Types**
This implementation showcases a **Virtual Proxy** (also called **Cache Proxy**) that:
- **Controls access** to expensive resources
- **Delays expensive operations** until actually needed
- **Caches results** for improved performance on subsequent calls
- **Provides lazy loading** to optimize resource usage

## **Real-World Applications**
* **Content Delivery Networks**: Caching web content and media files
* **Database Connection Pools**: Managing expensive database connections  
* **Image Loading Systems**: Lazy loading and caching of large images
* **Security Proxies**: Adding authentication and authorization layers
* **Logging Proxies**: Adding logging functionality without modifying original classes
* **Remote Proxies**: Representing objects in different address spaces (RMI, web services) 