package behavioral.visitor.nodes;

import behavioral.visitor.NodeVisitor;

public class BinaryOpNode implements ASTNode {
    private final ASTNode left;
    private final ASTNode right;
    private final String operator;
    
    public BinaryOpNode(ASTNode left, String operator, ASTNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
    
    public ASTNode getLeft() {
        return left;
    }
    
    public ASTNode getRight() {
        return right;
    }
    
    public String getOperator() {
        return operator;
    }
    
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
    }
} 