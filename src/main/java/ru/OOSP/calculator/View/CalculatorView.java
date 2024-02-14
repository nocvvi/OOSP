package ru.OOSP.calculator.View;

import java.util.Scanner;

public class CalculatorView {
    private Scanner scanner;

    public CalculatorView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInputEquation(){
        System.out.println(" Введите уравнение ");
        return scanner.nextLine();
    }
    public void displayResult(double result) {
        System.out.println("Результат вычислений: " + result);
    }

    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
