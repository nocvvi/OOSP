package ru.OOSP.calculator.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
    public double calculate(String equation) {
        try {
            Pattern pattern = Pattern.compile("(-?\\d+(?:\\.\\d+)?)|([+\\-*/^//])|\\(([^)]+)\\)");
            Matcher matcher = pattern.matcher(equation);

            double result = 0;
            String operator = "+";

            while (matcher.find()) {
                if (matcher.group(1) != null) { // Это число
                    double operand = Double.parseDouble(matcher.group(1));

                    switch (operator) {
                        case "+":
                            result += operand;
                            break;
                        case "-":
                            result -= operand;
                            break;
                        case "*":
                            result *= operand;
                            break;
                        case "/":
                            if (operand != 0) {
                                result /= operand;
                            } else {
                                throw new ArithmeticException("Деление на ноль");
                            }
                            break;
                        case "^":
                            result = Math.pow(result, operand);
                            break;
                        case "//":
                            result = Math.floorDiv((long) result, (long) operand);
                            break;
                        default:
                            throw new IllegalArgumentException("Недопустимый математический оператор: " + operator);
                    }
                } else if (matcher.group(2) != null) {
                    operator = matcher.group(2);
                } else if (matcher.group(3) != null) {
                    double subResult = calculate(matcher.group(3));
                    switch (operator) {
                        case "+":
                            result += subResult;
                            break;
                        case "-":
                            result -= subResult;
                            break;
                        case "*":
                            result *= subResult;
                            break;
                        case "/":
                            if (subResult != 0) {
                                result /= subResult;
                            } else {
                                throw new ArithmeticException("Деление на ноль");
                            }
                            break;
                        case "^":
                            result = Math.pow(result, subResult);
                            break;
                        case "//":
                            result = Math.floorDiv((long) result, (long) subResult);
                            break;
                        default:
                            throw new IllegalArgumentException("Недопустимый математический оператор: " + operator);
                    }
                }
            }

            return result;
        } catch (NumberFormatException | ArithmeticException e) {
            System.err.println("ОШИБКА в расчете " + e.getMessage());
            return Double.NaN;
        }
    }
}
