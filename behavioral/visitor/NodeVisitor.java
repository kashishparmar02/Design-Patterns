package behavioral.visitor;

import behavioral.visitor.nodes.NumberNode;
import behavioral.visitor.nodes.BinaryOpNode;
import behavioral.visitor.nodes.VariableNode;

public interface NodeVisitor {
    void visit(NumberNode node);
    void visit(BinaryOpNode node);
    void visit(VariableNode node);
} 