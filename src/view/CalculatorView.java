package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import calculatormodel.Calculator;
import calculatormodel.Operation;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import observerpattern.Observer;
import view.buttons.BaseButton;
import view.buttons.ButtonType;
import view.buttons.NumberButton;
import view.buttons.OperationButton;
import view.mainlabel.CalculatorLabel;

public class CalculatorView implements Observer {
	
	private CalculatorLabel calculatorLabel;
	
	private List<BaseButton> buttons;
	
	private Calculator calculator;
	
	public CalculatorView(Stage window, Calculator calculator) {
		this.calculatorLabel = new CalculatorLabel();
		this.buttons = new ArrayList<>();
		this.calculator = calculator;
		
		NumberButton button1 = new NumberButton(1);
		NumberButton button2 = new NumberButton(2);
		NumberButton button3 = new NumberButton(3);
		NumberButton button4 = new NumberButton(4);
		NumberButton button5 = new NumberButton(5);
		NumberButton button6 = new NumberButton(6);
		NumberButton button7 = new NumberButton(7);
		NumberButton button8 = new NumberButton(8);
		NumberButton button9 = new NumberButton(9);
		NumberButton button0 = new NumberButton(0);
		
		OperationButton buttonPlus = new OperationButton("+", Operation.ADDITION);
		OperationButton buttonMinus = new OperationButton("-", Operation.SUBTRACTION);
		OperationButton buttonMulti = new OperationButton("X", Operation.MULTIPLICATION);
		OperationButton buttonDiv = new OperationButton("/", Operation.DIVISION);
		
		BaseButton buttonComma = new BaseButton(".", ButtonType.COMMA);
		BaseButton buttonDelete = new BaseButton("<=", ButtonType.DELETE);
		BaseButton buttonReset = new BaseButton("C", ButtonType.RESET);
		BaseButton buttonEqual = new BaseButton("=", ButtonType.EQUAL);
		
		Collections.addAll(this.buttons, button1, button2, button3, button4, button5, button6, button7, button8, button9,
				button0, buttonPlus, buttonMinus, buttonMulti, buttonDiv, buttonComma, buttonDelete, buttonReset, buttonEqual);
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(1);
		gridPane.setHgap(1);
		gridPane.add(this.calculatorLabel, 0, 0, 4, 1);
		gridPane.add(buttonReset, 0, 1);
		gridPane.add(buttonDelete, 1, 1);
		gridPane.add(buttonDiv, 3, 1);
		gridPane.add(button7, 0, 2);
		gridPane.add(button8, 1, 2);
		gridPane.add(button9, 2, 2);
		gridPane.add(buttonMulti, 3, 2);
		gridPane.add(button4, 0, 3);
		gridPane.add(button5, 1, 3);
		gridPane.add(button6, 2, 3);
		gridPane.add(buttonMinus, 3, 3);
		gridPane.add(button1, 0, 4);
		gridPane.add(button2, 1, 4);
		gridPane.add(button3, 2, 4);
		gridPane.add(buttonPlus, 3, 4);
		gridPane.add(button0, 1, 5);
		gridPane.add(buttonComma, 2, 5);
		gridPane.add(buttonEqual, 3, 5);		
		
		Scene scene = new Scene(gridPane);
		window.setScene(scene);
		
	}
	
	public CalculatorLabel getCalculatorLabel() {
		return calculatorLabel;
	}

	public List<BaseButton> getButtons() {
		return this.buttons;
	}

	@Override
	public void update() {
		double result = calculator.getResult();
		if((result % 1) == 0) {
			this.calculatorLabel.setText(String.valueOf((int) Math.round(result)));		
		} else {
			this.calculatorLabel.setText(String.valueOf(result));
		}
	}

}
