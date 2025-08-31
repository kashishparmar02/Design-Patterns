package behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create context with boolean variables
        Map<String, Boolean> context = new HashMap<>();
        context.put("isActive", true);
        context.put("isAdmin", false);
        context.put("hasPermission", true);
        context.put("isBlocked", false);
        
        System.out.println("=== Boolean Logic Interpreter Pattern ===");
        System.out.println("Context: " + context);
        System.out.println();
        
        // Example 1: Build expressions programmatically
        System.out.println("--- Building Expressions Programmatically ---");
        
        Expression rule1 = new AndExpr(
            new VariableExpr("isActive"),
            new VariableExpr("hasPermission")
        );
        
        Expression rule2 = new OrExpr(
            new VariableExpr("isAdmin"),
            new AndExpr(
                new VariableExpr("isActive"),
                new NotExpr(new VariableExpr("isBlocked"))
            )
        );
        
        System.out.println("Rule 1: " + rule1);
        System.out.println("Result: " + rule1.interpret(context));
        System.out.println();
        
        System.out.println("Rule 2: " + rule2);
        System.out.println("Result: " + rule2.interpret(context));
        System.out.println();
        
        // Example 2: Parse expressions from strings
        System.out.println("--- Parsing Expressions from Strings ---");
        
        String[] expressions = {
            "isActive AND hasPermission",
            "isAdmin OR isActive",
            "NOT isBlocked",
            "(isAdmin OR hasPermission) AND isActive",
            "NOT (isBlocked OR NOT isActive)"
        };
        
        for (String exprStr : expressions) {
            try {
                Expression expr = SimpleParser.parse(exprStr);
                boolean result = expr.interpret(context);
                System.out.println("Expression: " + exprStr);
                System.out.println("Parsed as: " + expr);
                System.out.println("Result: " + result);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error parsing: " + exprStr + " - " + e.getMessage());
            }
        }
        
        // Example 3: Dynamic context changes
        System.out.println("--- Dynamic Context Changes ---");
        Expression dynamicRule = new AndExpr(
            new OrExpr(new VariableExpr("isAdmin"), new VariableExpr("hasPermission")),
            new NotExpr(new VariableExpr("isBlocked"))
        );
        
        System.out.println("Rule: " + dynamicRule);
        System.out.println("Original result: " + dynamicRule.interpret(context));
        
        // Change context
        context.put("isBlocked", true);
        System.out.println("After blocking user: " + dynamicRule.interpret(context));
        
        context.put("isAdmin", true);
        System.out.println("After making admin: " + dynamicRule.interpret(context));
    }
} 