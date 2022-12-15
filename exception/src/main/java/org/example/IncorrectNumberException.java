package org.example;

public class IncorrectNumberException extends Exception {
    private final int defaultValue;
    public int getDefaultValue(){
     return defaultValue;
    }
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public IncorrectNumberException(String s, int defaultVal){
        super(s);
        defaultValue = defaultVal;
    }
}
