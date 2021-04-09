package calculatormodel.state;

import calculatormodel.Calculator;
import calculatormodel.myexception.DivideByZeroException;

public interface AbstractState {
	
	public static AbstractState getInitialState() {
		return new ReadFirstNumberState();
	}
	
	public abstract void goNext(Calculator context);
	
	public abstract void pressedEqual(Calculator context);
	
	public abstract void pressedReset(Calculator context);
	
	public abstract void pressedOperation(Calculator context) throws DivideByZeroException;
	
	public abstract void readNumber(Calculator context, double number);

}
