package org.burroloco.test.util.expression;

public class InvalidExpressionException extends RuntimeException {
    public InvalidExpressionException(String expression) {
        super("Invalid expression: " + expression);
    }
}
