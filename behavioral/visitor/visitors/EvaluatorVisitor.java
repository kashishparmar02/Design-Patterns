package behavioral.visitor.visitors;

import java.util.HashMap;
import java.util.Map;
import behavioral.visitor.NodeVisitor;
import behavioral.visitor.nodes.NumberNode;
import behavioral.visitor.nodes.VariableNode;
import behavioral.visitor.nodes.BinaryOpNode;

public class EvaluatorVisitor implements NodeVisitor {
    private double result;
    private Map<String, Double> variables = new HashMap<>();
    
    public EvaluatorVisitor() {
        // Initialize some variables for demo
        variables.put("x", 10.0);
        variables.put("y", 5.0);
    }
    
    public double getResult() {
        return result;
    }
    
    @Override
    public void visit(NumberNode node) {
        result = node.getValue();
    }
    
    @Override
    public void visit(VariableNode node) {
        result = variables.getOrDefault(node.getName(), 0.0);
    }
    
    @Override
    public void visit(BinaryOpNode node) {
        node.getLeft().accept(this);
        double leftValue = result;
        
        node.getRight().accept(this);
        double rightValue = result;
        
        switch (node.getOperator()) {
            case "+":
                result = leftValue + rightValue;
                break;
            case "-":
                result = leftValue - rightValue;
                break;
            case "*":
                result = leftValue * rightValue;
                break;
            case "/":
                result = rightValue != 0 ? leftValue / rightValue : 0;
                break;
            default:
                result = 0;
        }
    }
} 