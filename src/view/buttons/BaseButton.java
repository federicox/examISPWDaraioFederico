package view.buttons;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BaseButton extends Button {
	
	private String symbol;
	
	private ButtonType buttonType;
	
	public BaseButton(String symbol, ButtonType buttonType) {
		super();
		this.symbol = symbol;
		this.buttonType = buttonType;
		this.setText(this.symbol);
		this.setFont(Font.font("Agency FB", FontWeight.MEDIUM, 20));
		this.setPrefSize(60, 60);
		this.setStyle("-fx-border-color: black;");
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public ButtonType getButtonType() {
		return buttonType;
	}

	public void setButtonType(ButtonType buttonType) {
		this.buttonType = buttonType;
	}

}
