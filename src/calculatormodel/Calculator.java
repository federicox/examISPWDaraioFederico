package calculatormodel;

import calculatormodel.myexception.DivideByZeroException;
import calculatormodel.state.AbstractState;
import observerpattern.Subject;

public class Calculator extends Subject {
	
	private double result;
	
	private Operation operation;
	
	private double firstNumber;
	
	private double secondNumber;
	
	private AbstractState currentState;
	
	public Calculator() {
		this.setFirstNumber(0);
		this.setSecondNumber(0);
		this.setResult(0);
		this.setCurrentState(AbstractState.getInitialState());
		this.operation = Operation.ADDITION;
	}
	
	public void readNumber(double number) {
		this.currentState.readNumber(this, number);
	}
	
	public void addition() {
		this.setResult(firstNumber + secondNumber);
	}
	
	public void subtraction() {
		this.setResult(firstNumber - secondNumber);
	}
	
	public void multiplication() {
		this.setResult(firstNumber * secondNumber);
	}
	
	public void division() throws DivideByZeroException {
		if(secondNumber == 0) {
			throw new DivideByZeroException();
		} else {
			this.setResult(firstNumber / secondNumber);
		}
	}
	
	public void doOperation() throws DivideByZeroException {		
		switch(this.operation) {
		case ADDITION:
			this.addition();
			break;
		case SUBTRACTION:
			this.subtraction();
			break;
		case MULTIPLICATION:
			this.multiplication();
			break;
		case DIVISION:
			this.division();
			break;
		default:
			break;
		}
	}
	
	public void setOperation(Operation operation) throws DivideByZeroException {
		this.currentState.pressedOperation(this);
		this.operation = operation;
	}
	
	public void equal() throws DivideByZeroException {
		this.doOperation();
		this.currentState.pressedEqual(this);
	}
	
	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public void reset() {
		this.setFirstNumber(0);
		this.setSecondNumber(0);
		this.setResult(0);
		
		this.currentState.pressedReset(this);
	}
	
	public void setResult(double result) {
		this.result = result;
		this.notifyObservers();
	}
	
	public double getResult() {
		return this.result;
	}	

	public AbstractState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(AbstractState currentState) {
		this.currentState = currentState;
	}

}
