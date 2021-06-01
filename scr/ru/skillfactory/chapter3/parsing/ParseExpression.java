package ru.skillfactory.chapter3.parsing;

import java.util.Arrays;

public class ParseExpression {
    Operations operations = new Operations();

    public String[] exec(String expexpression) {
        int countOperation = operations.getCountOperations(expexpression);
        if(countOperation==0) return new String[]{};
        countOperation+=countOperation+1;

        String[] operMass = new String[countOperation];
        Arrays.fill(operMass,"");
        String buf = "";
        int massIterator = 0;
        for (int i = 0; i < expexpression.length(); i++) {
            char simbol = expexpression.charAt(i);
            if(operations.isOperation(simbol)) {
                operMass[massIterator++] = buf;
                operMass[massIterator] = operMass[massIterator] + simbol;
                massIterator++;
                buf="";
            } else buf = buf+simbol;
        }
        if(buf.length()>0){
            operMass[massIterator] = buf;
        }

        return operMass;
    }
}
