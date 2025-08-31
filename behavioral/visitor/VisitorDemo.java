package behavioral.visitor;

import behavioral.visitor.nodes.ASTNode;
import behavioral.visitor.nodes.BinaryOpNode;
import behavioral.visitor.nodes.NumberNode;
import behavioral.visitor.nodes.VariableNode;
import behavioral.visitor.visitors.EvaluatorVisitor;
import behavioral.visitor.visitors.PrinterVisitor;

public class VisitorDemo {
    public static void main(String[] args) {
        // Build AST for expression: (x + 3) * (y - 2)
        ASTNode expression = new BinaryOpNode(
            new BinaryOpNode(
                new VariableNode("x"),
                "+",
                new NumberNode(3)
            ),
            "*",
            new BinaryOpNode(
                new VariableNode("y"),
                "-",
                new NumberNode(2)
            )
        );
        
        // Use PrinterVisitor to display the expression
        PrinterVisitor printer = new PrinterVisitor();
        expression.accept(printer);
        System.out.println("Expression: " + printer.getResult());
        
        // Use EvaluatorVisitor to calculate the result
        EvaluatorVisitor evaluator = new EvaluatorVisitor();
        expression.accept(evaluator);
        System.out.println("Result: " + evaluator.getResult());
        
        // Build and evaluate another expression: x * 2 + y
        printer.reset();
        ASTNode simpleExpr = new BinaryOpNode(
            new BinaryOpNode(
                new VariableNode("x"),
                "*",
                new NumberNode(2)
            ),
            "+",
            new VariableNode("y")
        );
        
        simpleExpr.accept(printer);
        System.out.println("\nExpression: " + printer.getResult());
        
        simpleExpr.accept(evaluator);
        System.out.println("Result: " + evaluator.getResult());
    }
} 