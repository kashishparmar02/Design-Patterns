package behavioral.interpreter;

import java.util.ArrayList;
import java.util.List;

public class SimpleParser {
    
    public static Expression parse(String input) {
        List<String> tokens = tokenize(input);
        return parseExpression(tokens, 0).expression;
    }
    
    private static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        String[] parts = input.replaceAll("\\(", " ( ")
                              .replaceAll("\\)", " ) ")
                              .split("\\s+");
        
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                tokens.add(part.trim());
            }
        }
        return tokens;
    }
    
    private static ParseResult parseExpression(List<String> tokens, int index) {
        ParseResult left = parseTerm(tokens, index);
        index = left.nextIndex;
        
        while (index < tokens.size() && 
               (tokens.get(index).equals("OR") || tokens.get(index).equals("AND"))) {
            String operator = tokens.get(index);
            index++;
            
            ParseResult right = parseTerm(tokens, index);
            index = right.nextIndex;
            
            if (operator.equals("OR")) {
                left = new ParseResult(new OrExpr(left.expression, right.expression), index);
            } else {
                left = new ParseResult(new AndExpr(left.expression, right.expression), index);
            }
        }
        
        return left;
    }
    
    private static ParseResult parseTerm(List<String> tokens, int index) {
        if (tokens.get(index).equals("NOT")) {
            index++;
            ParseResult result = parseTerm(tokens, index);
            return new ParseResult(new NotExpr(result.expression), result.nextIndex);
        }
        
        if (tokens.get(index).equals("(")) {
            index++;
            ParseResult result = parseExpression(tokens, index);
            index = result.nextIndex;
            if (index < tokens.size() && tokens.get(index).equals(")")) {
                index++;
            }
            return new ParseResult(result.expression, index);
        }
        
        // Variable
        return new ParseResult(new VariableExpr(tokens.get(index)), index + 1);
    }
    
    private static class ParseResult {
        final Expression expression;
        final int nextIndex;
        
        ParseResult(Expression expression, int nextIndex) {
            this.expression = expression;
            this.nextIndex = nextIndex;
        }
    }
} 