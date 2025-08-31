package behavioral.visitor.visitors;

import behavioral.visitor.NodeVisitor;
import behavioral.visitor.nodes.NumberNode;
import behavioral.visitor.nodes.VariableNode;
import behavioral.visitor.nodes.BinaryOpNode;

public class PrinterVisitor implements NodeVisitor {
    private StringBuilder result = new StringBuilder();
    
    public String getResult() {
        return result.toString();
    }
    
    public void reset() {
        result = new StringBuilder();
    }
    
    @Override
    public void visit(NumberNode node) {
        result.append(node.getValue());
    }
    
    @Override
    public void visit(VariableNode node) {
        result.append(node.getName());
    }
    
    @Override
    public void visit(BinaryOpNode node) {
        result.append("(");
        node.getLeft().accept(this);
        result.append(" ").append(node.getOperator()).append(" ");
        node.getRight().accept(this);
        result.append(")");
    }
} 