package ru.skillfactory.chapter3.main;

import ru.skillfactory.chapter3.calc.CalcExpression;
import ru.skillfactory.chapter3.parsing.ParseExpression;

import java.util.Scanner;

public class chapter3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParseExpression parseExpression = new ParseExpression();
        CalcExpression calcExpression = new CalcExpression();

        String exp = scanner.nextLine();

        String[] expArr = parseExpression.exec(exp);
        double result = calcExpression.execCalc(expArr);
        System.out.println(result);
    }
}
