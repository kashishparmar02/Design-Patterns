package behavioral.visitor.nodes;

import behavioral.visitor.NodeVisitor;

public class NumberNode implements ASTNode {
    private final double value;
    
    public NumberNode(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
    
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
} 