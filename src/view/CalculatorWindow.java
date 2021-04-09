package view;

import calculatormodel.Calculator;
import controller.CalculatorController;
import javafx.application.Application;
import javafx.stage.Stage;

public class CalculatorWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.show();
		
		Calculator calculator = new Calculator();
		CalculatorView calculatorView = new CalculatorView(primaryStage , calculator);
		calculator.attach(calculatorView);
		new CalculatorController(calculatorView, calculator);
		primaryStage.setResizable(false);
	}
	
	public static void main (String [] args) {
		launch(args);
	}

}
