package behavioral.visitor.nodes;

import behavioral.visitor.NodeVisitor;

public interface ASTNode {
    void accept(NodeVisitor visitor);
} 