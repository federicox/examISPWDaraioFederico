package calculatormodel.state;

import calculatormodel.Calculator;
import calculatormodel.myexception.DivideByZeroException;

public class ReadSecondNumberState implements AbstractState {

	@Override
	public void goNext(Calculator context) {
		context.setCurrentState(new ReadFirstNumberState());
	}

	@Override
	public void pressedEqual(Calculator context) {
		this.goNext(context);
	}

	@Override
	public void pressedReset(Calculator context) {
		this.goNext(context);
	}

	@Override
	public void pressedOperation(Calculator context) throws DivideByZeroException {
		context.doOperation();
		context.setFirstNumber(context.getResult());
	}

	@Override
	public void readNumber(Calculator context, double number) {
		context.setSecondNumber(number);
	}

}
