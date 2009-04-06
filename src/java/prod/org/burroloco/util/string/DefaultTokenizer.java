package org.burroloco.util.string;

public class DefaultTokenizer implements Tokenizer {
    private static final String AT = "@";

    public String token(String identifier) {
        return AT + identifier + AT;
    }
}
