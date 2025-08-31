package behavioral.visitor.nodes;

import behavioral.visitor.NodeVisitor;

public class VariableNode implements ASTNode {
    private final String name;
    
    public VariableNode(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
} 