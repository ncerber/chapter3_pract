package ru.skillfactory.chapter3.calc;

import ru.skillfactory.chapter3.parsing.Operations;

public class CalcExpression {
    Operations operations = new Operations();

    private double addition(double firstOper, double secondOper) {
        return firstOper + secondOper;
    }

    private double subtraction(double firstOper, double secondOper) {
        return firstOper - secondOper;
    }

    private double multiplication(double firstOper, double secondOper) {
        return firstOper * secondOper;
    }

    private double division(double firstOper, double secondOper) {
        if (secondOper != 0) {
            return firstOper / secondOper;
        } else return 0;
    }

    private double calcOper(String firstOper, String secondOper, char operation) {
        double dFirstOper = Double.parseDouble(firstOper);
        double dSecondOper = Double.parseDouble(secondOper);

        switch (operation) {
            case '+':
                return addition(dFirstOper, dSecondOper);

            case '-':
                return subtraction(dFirstOper, dSecondOper);

            case '*':
                return multiplication(dFirstOper, dSecondOper);

            case '/':
                return division(dFirstOper, dSecondOper);

            default:
                return 0;
        }
    }

    private int findFirstOper(String[] sMass, int currentIter){
        int lCurrentIter = currentIter-1;

        while (true){
            if(sMass[lCurrentIter].length()>0) return lCurrentIter;
            if(lCurrentIter<0) return -1;
            lCurrentIter--;
        }
    }

    public double execCalc(String[] expression) {
        double result = 0;
        boolean isCalc = true;

        int iter = 0;
        if (expression.length == 0) return 0;

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].length()==0) continue;
            if (operations.isHighOperation(expression[i].charAt(0))) {
                int fIter = findFirstOper(expression,i);
                if (fIter<0) return 0;
                String fOper = expression[fIter];
                String sOper = "";

                boolean isFind = false;

                int secondIter = i + 1;

                if (secondIter >= expression.length) {
                    break;
                }

                while (!isFind) {
                    if (expression[secondIter].length() > 0) {
                        isFind = true;
                    } else secondIter++;
                    if (secondIter >= expression.length) break;
                }
                if (isFind) sOper = expression[secondIter];
                else sOper = "1";

                double res = calcOper(fOper, sOper, expression[i].charAt(0));
                expression[fIter] = String.valueOf(res);
                expression[i] = "";
                expression[secondIter] = "";
            }
        }

        for (int i = 0; i < expression.length; i++) {
            if (expression[i].length()==0) continue;
            if (operations.isLowOperation(expression[i].charAt(0))) {
                int fIter = findFirstOper(expression,i);
                if (fIter<0) return 0;
                String fOper = expression[fIter];
                String sOper = "";

                boolean isFind = false;

                int secondIter = i + 1;

                if (secondIter >= expression.length) {
                    break;
                }

                while (!isFind) {
                    if (expression[secondIter].length() > 0) {
                        isFind = true;
                    } else secondIter++;
                    if (secondIter >= expression.length) break;
                }
                if (isFind) sOper = expression[secondIter];
                else sOper = "1";

                double res = calcOper(fOper, sOper, expression[i].charAt(0));
                expression[fIter] = String.valueOf(res);
                expression[i] = "";
                expression[secondIter] = "";
            }
        }

        return Double.parseDouble(expression[0]);
    }
}
