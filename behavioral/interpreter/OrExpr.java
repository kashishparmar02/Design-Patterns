package behavioral.interpreter;

import java.util.Map;

public class OrExpr implements Expression {
    private final Expression left;
    private final Expression right;
    
    public OrExpr(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean interpret(Map<String, Boolean> context) {
        return left.interpret(context) || right.interpret(context);
    }
    
    @Override
    public String toString() {
        return "(" + left + " OR " + right + ")";
    }
} 