package ru.skillfactory.chapter3.parsing;

import java.util.Arrays;

public class ParseExpression {
    private char[] Operations = {'+', '-', '/', '*'};

    private boolean isOperation(char Operation){
        for (char ch : Operations) {
            if(ch==Operation) return true;
        }
        return false;
    }

    private int getCountOperations(String expexpression) {
        int tCountOperation = 0;
        for (int i = 0; i < expexpression.length(); i++) {
            if(isOperation(expexpression.charAt(i))) tCountOperation++;
        }

        return tCountOperation;
    }

    public String[] exec(String expexpression) {
        int countOperation = getCountOperations(expexpression);
        if(countOperation==0) return new String[]{};
        countOperation+=countOperation+1;

        String[] operMass = new String[countOperation];
        Arrays.fill(operMass,"");
        String buf = "";
        int massIterator = 0;
        for (int i = 0; i < expexpression.length(); i++) {
            char simbol = expexpression.charAt(i);
            if(isOperation(simbol)) {
                operMass[massIterator++] = buf;
                operMass[massIterator] = operMass[massIterator] + simbol;
                massIterator++;
                buf="";
            } else buf = buf+simbol;
        }

        return new String[]{};
    }
}
