package behavioral.interpreter;

import java.util.Map;

public class VariableExpr implements Expression {
    private final String name;
    
    public VariableExpr(String name) {
        this.name = name;
    }
    
    @Override
    public boolean interpret(Map<String, Boolean> context) {
        return context.getOrDefault(name, false);
    }
    
    @Override
    public String toString() {
        return name;
    }
} 