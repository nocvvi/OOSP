package ru.OOSP.calculator.Controller;
import ru.OOSP.calculator.Model.CalculatorModel;
import ru.OOSP.calculator.View.CalculatorView;

public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void processEquation(){
        try {
            String inputEquation = view.getInputEquation();
            double result = model.calculate(inputEquation);
            view.displayResult(result);
        }catch (Exception e){
            view.displayError("Произошла ошибка " + e.getMessage());
        }
    }
}
