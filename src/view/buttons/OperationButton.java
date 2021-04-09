package view.buttons;

import calculatormodel.Operation;

public class OperationButton extends BaseButton {
	
	private Operation operation;
	
	public OperationButton(String symbol, Operation operation) {
		super(symbol, ButtonType.OPERATION);
		this.setOperation(operation);
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

}
