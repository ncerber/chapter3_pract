package ru.skillfactory.chapter3.parsing;

public class Operations {
    private char[] Operations = {'+', '-', '/', '*'};
    private char[] highOperations = {'*', '/'};
    private char[] lowOperations = {'+', '-'};

    public boolean isHighOperation(char Operation) {
        for (char ch : highOperations) {
            if (ch == Operation) return true;
        }
        return false;
    }

    public boolean isLowOperation(char Operation) {
        for (char ch : lowOperations) {
            if (ch == Operation) return true;
        }
        return false;
    }

    public boolean isOperation(char Operation) {
        for (char ch : Operations) {
            if (ch == Operation) return true;
        }
        return false;
    }

    public int getCountOperations(String expexpression) {
        int tCountOperation = 0;
        for (int i = 0; i < expexpression.length(); i++) {
            if (isOperation(expexpression.charAt(i))) tCountOperation++;
        }

        return tCountOperation;
    }
}
