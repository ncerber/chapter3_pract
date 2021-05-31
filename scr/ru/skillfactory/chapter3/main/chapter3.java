package ru.skillfactory.chapter3.main;

import ru.skillfactory.chapter3.parsing.ParseExpression;

import java.util.Scanner;

public class chapter3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParseExpression parseExpression = new ParseExpression();

        String exp = scanner.nextLine();

        String[] expArr = parseExpression.exec(exp);
    }
}
