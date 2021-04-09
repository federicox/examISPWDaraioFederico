package controller;

import calculatormodel.Calculator;
import calculatormodel.Operation;
import calculatormodel.myexception.DivideByZeroException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.CalculatorView;
import view.buttons.BaseButton;
import view.buttons.OperationButton;

public class CalculatorController {
	
	private CalculatorView calculatorView;
	
	private Calculator calculatorModel;
	
	public CalculatorController(CalculatorView calculatorView, Calculator calculatorModel) {
		this.calculatorView = calculatorView;
		this.calculatorModel = calculatorModel;
		
		this.calculatorModel.reset();
		
		for(BaseButton button : this.calculatorView.getButtons()) {
			switch(button.getButtonType()) {
			case NUMBER:
				button.setOnAction(new BaseButtonHandler(button));
				break;
			case OPERATION:
				button.setOnAction(new OperationButtonHandler(button));
				break;
			case COMMA:
				button.setOnAction(new BaseButtonHandler(button));
				break;
			case DELETE:
				button.setOnAction(new DeleteButtonHandler(button));
				break;
			case EQUAL:
				button.setOnAction(new EqualButtonHandler(button));
				break;
			case RESET:
				button.setOnAction(new ResetButtonHandler(button));
				break;
			
			}
		}		
	}
	
	private class BaseButtonHandler implements EventHandler<ActionEvent> {

		private BaseButton button;
		
		public BaseButtonHandler(BaseButton button) {
			this.setButton(button);
		}
		
		@Override
		public void handle(ActionEvent event) {
			calculatorView.getCalculatorLabel().addDigit(button.getSymbol());			
		}

		public BaseButton getButton() {
			return button;
		}

		public void setButton(BaseButton button) {
			this.button = button;
		}
		
	}
	
	private class OperationButtonHandler extends BaseButtonHandler {

		public OperationButtonHandler(BaseButton button) {
			super(button);
		}

		@Override
		public void handle(ActionEvent event) {
			double number = Double.parseDouble(calculatorView.getCalculatorLabel().getNumber());
			Operation operation = ((OperationButton) super.getButton()).getOperation();
			calculatorModel.readNumber(number);
			try {
				calculatorModel.setOperation(operation);
			} catch (DivideByZeroException e) {
				calculatorView.getCalculatorLabel().setErrorMessage();
			}
			calculatorView.getCalculatorLabel().setNewNumber(true);
		}
		
	}
	
	private class DeleteButtonHandler extends BaseButtonHandler {

		public DeleteButtonHandler(BaseButton button) {
			super(button);
		}

		@Override
		public void handle(ActionEvent event) {
			calculatorView.getCalculatorLabel().deleteDigit();
		}		
		
	}
	
	private class EqualButtonHandler extends BaseButtonHandler {

		public EqualButtonHandler(BaseButton button) {
			super(button);
		}

		@Override
		public void handle(ActionEvent event) {
			double number = Double.parseDouble(calculatorView.getCalculatorLabel().getNumber());
			calculatorModel.readNumber(number);
			try {
				calculatorModel.equal();
			} catch (DivideByZeroException e) {
				calculatorView.getCalculatorLabel().setErrorMessage();
			}
			calculatorView.getCalculatorLabel().setNewNumber(true);
		}
		
	}
	
	private class ResetButtonHandler extends BaseButtonHandler {

		public ResetButtonHandler(BaseButton button) {
			super(button);
		}

		@Override
		public void handle(ActionEvent event) {
			calculatorModel.reset();
			calculatorView.getCalculatorLabel().setNewNumber(true);
		}
		
	}

}
