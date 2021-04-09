package calculatormodel.state;

import calculatormodel.Calculator;

public class ReadFirstNumberState implements AbstractState {

	@Override
	public void goNext(Calculator context) {
		context.setCurrentState(new ReadSecondNumberState());
	}

	@Override
	public void pressedEqual(Calculator context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressedReset(Calculator context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pressedOperation(Calculator context) {
		this.goNext(context);		
	}

	@Override
	public void readNumber(Calculator context, double number) {
		context.setFirstNumber(number);		
	}

}
