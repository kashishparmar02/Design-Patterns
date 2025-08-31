package behavioral.interpreter;

import java.util.Map;

public class NotExpr implements Expression {
    private final Expression expression;
    
    public NotExpr(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public boolean interpret(Map<String, Boolean> context) {
        return !expression.interpret(context);
    }
    
    @Override
    public String toString() {
        return "NOT " + expression;
    }
} 