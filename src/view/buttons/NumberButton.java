package view.buttons;

public class NumberButton extends BaseButton {
	
	private int value;
	
	public NumberButton(int value) {
		super(String.valueOf(value), ButtonType.NUMBER);
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
