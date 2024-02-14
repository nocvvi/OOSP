package ru.OOSP.calculator;

import static ru.OOSP.calculator.Calculator.calc;
import static ru.OOSP.calculator.Calculator.getInt;
import static ru.OOSP.calculator.Calculator.getOperation;

public class Main {
    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        System.out.println("рузультат " + result);
    }
}