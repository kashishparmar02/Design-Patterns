# Visitor Pattern - AST Expression Evaluator

The Visitor pattern allows you to define operations on objects without modifying their classes. This example demonstrates the pattern using an Abstract Syntax Tree (AST) for mathematical expressions.

## Structure

### AST Nodes (Elements)
- **ASTNode**: Base interface for all expression nodes
- **NumberNode**: Represents literal numbers (e.g., 5, 3.14)
- **VariableNode**: Represents variables (e.g., x, y)
- **BinaryOpNode**: Represents binary operations (+, -, *, /)

### Visitors (Operations)
- **NodeVisitor**: Interface defining visit methods for each node type
- **EvaluatorVisitor**: Calculates the numeric result of expressions
- **PrinterVisitor**: Generates string representation of expressions

## Example Usage

```java
// Build AST for: (x + 3) * (y - 2)
ASTNode expr = new BinaryOpNode(
    new BinaryOpNode(new VariableNode("x"), "+", new NumberNode(3)),
    "*", 
    new BinaryOpNode(new VariableNode("y"), "-", new NumberNode(2))
);

// Print the expression
PrinterVisitor printer = new PrinterVisitor();
expr.accept(printer);
System.out.println(printer.getResult()); // Output: ((x + 3.0) * (y - 2.0))

// Evaluate the expression
EvaluatorVisitor evaluator = new EvaluatorVisitor();
expr.accept(evaluator);
System.out.println(evaluator.getResult()); // Output: 39.0 (with x=10, y=5)
```

## Benefits

- **Separation of Concerns**: Operations are separate from data structure
- **Easy Extension**: Add new visitors without modifying existing nodes
- **Type Safety**: Compile-time checking of visitor methods
- **Clean Code**: Each visitor focuses on one specific operation

This pattern is particularly useful for compilers, interpreters, and any system that needs to perform multiple operations on a tree-like data structure. 