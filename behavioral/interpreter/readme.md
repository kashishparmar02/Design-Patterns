# **Interpreter Pattern – Boolean Logic Expression Evaluator**

This project demonstrates the **Interpreter Pattern** through a boolean logic expression evaluator. The pattern defines how to evaluate sentences in a language by representing grammar rules as classes, enabling dynamic evaluation of complex boolean expressions.

## **Project Structure**
```
interpreter/
├── Expression.java              (Abstract Expression Interface)
├── VariableExpr.java           (Terminal Expression - Variables)
├── AndExpr.java                (Non-Terminal Expression - AND)
├── OrExpr.java                 (Non-Terminal Expression - OR)
├── NotExpr.java                (Non-Terminal Expression - NOT)
├── SimpleParser.java           (Parser - String to Expression Tree)
└── Main.java                   (Client/Demo)
```

## **Expression Evaluation Process**
1. **Expression tree built** either programmatically or parsed from strings
2. **Context provided** with boolean variable values (isActive=true, isAdmin=false, etc.)
3. **Recursive interpretation** starts from root expression node
4. **Each node evaluates** its sub-expressions and applies its specific logic
5. **Final result returned** as boolean value representing the expression outcome

## **Pattern Benefits**
* **Interpreter Pattern** separates grammar rules from the data they operate on
* Easy to add new operators without modifying existing expression classes
* Supports both programmatic building and string parsing of expressions
* Enables dynamic rule evaluation with different contexts
* Follows Composite Pattern internally for tree structure management
* Supports complex nested expressions with proper operator precedence

## **Key Components**

### **Abstract Expression (Expression)**
- `interpret(Map<String, Boolean> context)` - Evaluates expression with given variable values
- Defines contract for all expression types in the grammar

### **Terminal Expressions (VariableExpr)**
- Represents leaf nodes in expression tree (boolean variables)
- Looks up variable values from context during interpretation
- No sub-expressions to evaluate

### **Non-Terminal Expressions (AndExpr, OrExpr, NotExpr)**
- **AndExpr**: Evaluates both sub-expressions, returns logical AND result
- **OrExpr**: Evaluates both sub-expressions, returns logical OR result  
- **NotExpr**: Evaluates single sub-expression, returns logical NOT result
- Contains references to other expressions forming tree structure

### **Parser (SimpleParser)**
- Tokenizes input strings into grammar symbols
- Builds expression tree from tokens using recursive descent parsing
- Handles operator precedence and parentheses grouping
- Converts human-readable strings to executable expression objects

### **Client (Main)**
- Demonstrates programmatic expression building
- Shows string parsing capabilities with various expression formats
- Illustrates dynamic context changes and re-evaluation
- Simulates real-world scenarios like access control rules

## **Running the Demo**
```bash
# Navigate to parent directory of interpreter folder
cd behavioral

# Compile all files
javac -d ../bin interpreter/*.java

# Run demo
java -cp ../bin behavioral.interpreter.Main
```

The demo demonstrates:
- Building boolean expressions programmatically using constructor calls
- Parsing expressions from strings like "isActive AND hasPermission"
- Dynamic context evaluation with different variable values
- Complex nested expressions with proper logical evaluation
- Real-time rule changes and immediate re-evaluation results

## **Execution Flow Example**
```
=== Boolean Logic Interpreter Pattern ===
Context: {hasPermission=true, isBlocked=false, isAdmin=false, isActive=true}

Rule 1: (isActive AND hasPermission)                    ← Expression tree built
Result: true                                            ← Recursive interpretation

Parsing: "isActive AND hasPermission"                   ← String input
Parsed as: (isActive AND hasPermission)                 ← Parser builds tree
Result: true                                            ← Same logical result

After blocking user: false                              ← Context change affects result
After making admin: false                               ← Multiple context changes
```

## **Real-World Applications**
* **Access Control Systems**: User permission and role-based authorization rules
* **Business Rule Engines**: Dynamic business logic evaluation and decision making
* **Feature Flag Systems**: Environment-based feature enablement and A/B testing
* **Search Query Processing**: Complex boolean search filters and criteria
* **Configuration Management**: Environment-specific settings and conditional logic
* **Validation Systems**: Form validation rules and data integrity constraints
* **Workflow Engines**: Conditional task execution and process flow control
* **Game Development**: Achievement systems, quest conditions, and game state logic 