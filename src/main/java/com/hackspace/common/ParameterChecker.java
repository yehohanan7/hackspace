package com.hackspace.common;


public class ParameterChecker {

    public void notNull(Object ... inputs) {
        for (Object input : inputs) {
            if (input == null)
                throw new IllegalArgumentException("invalid orgument");
        }
    }
}
