package ru.OOSP.calculator;

import ru.OOSP.calculator.Controller.CalculatorController;
import ru.OOSP.calculator.Model.CalculatorModel;
import ru.OOSP.calculator.View.CalculatorView;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView(new Scanner(System.in));
        CalculatorController controller = new CalculatorController(model, view);

        controller.processEquation();

    }
}