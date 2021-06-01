package ru.skillfactory.chapter3.main;

import ru.skillfactory.chapter3.calc.CalcExpression;
import ru.skillfactory.chapter3.parsing.ParseExpression;

import java.util.Scanner;

public class chapter3 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ParseExpression parseExpression = new ParseExpression();
//        CalcExpression calcExpression = new CalcExpression();
//
//        String exp = scanner.nextLine();
//
//        String[] expArr = parseExpression.exec(exp);
//        double result = calcExpression.execCalc(expArr);
//        System.out.println(result);
        test();
    }

    public static void test() {
        ParseExpression parseExpression = new ParseExpression();
        CalcExpression calcExpression = new CalcExpression();

        String testString = "5*3*2";
        double testRes = 30.0;
        String[] expArr = parseExpression.exec(testString);
        double result = calcExpression.execCalc(expArr);
        boolean isTrue = result == testRes;
        System.out.println("Выражение:" + testString + "; Расчет: " + result + "; Правильный ответ:" + testRes + "; Правильно:" + isTrue);

        testString = "5*3+2";
        testRes = 17.0;
        expArr = parseExpression.exec(testString);
        result = calcExpression.execCalc(expArr);
        isTrue = result == testRes;
        System.out.println("Выражение:" + testString + "; Расчет: " + result + "; Правильный ответ:" + testRes + "; Правильно:" + isTrue);

        testString = "5+3*2";
        testRes = 11.0;
        expArr = parseExpression.exec(testString);
        result = calcExpression.execCalc(expArr);
        isTrue = result == testRes;
        System.out.println("Выражение:" + testString + "; Расчет: " + result + "; Правильный ответ:" + testRes + "; Правильно:" + isTrue);

        testString = "5/2+2*5";
        testRes = 12.5;
        expArr = parseExpression.exec(testString);
        result = calcExpression.execCalc(expArr);
        isTrue = result == testRes;
        System.out.println("Выражение:" + testString + "; Расчет: " + result + "; Правильный ответ:" + testRes + "; Правильно:" + isTrue);
    }
}
