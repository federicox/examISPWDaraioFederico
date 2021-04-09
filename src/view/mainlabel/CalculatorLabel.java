package view.mainlabel;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CalculatorLabel extends Label {
	
	private boolean newNumber = true;
	
	public CalculatorLabel() {
		this.setFont(Font.font("Agency FB", FontWeight.BOLD, 30));
		this.setMaxWidth(Double.MAX_VALUE);
		this.setAlignment(Pos.CENTER_RIGHT);
		this.setStyle("-fx-border-color: black;" + "-fx-border-width: 2px");
		this.setPadding(new Insets(2));
	}
	
	public void setErrorMessage() {
		this.setText("Error divide by zero.");
	}

	public boolean isNewNumber() {
		return newNumber;
	}

	public void setNewNumber(boolean newNumber) {
		this.newNumber = newNumber;
	}
	
	public void addDigit(String digit) {
		if(this.isNewNumber())
			this.resetNumber();
		
		this.setText(this.getText() + digit);
		this.newNumber = false;
	}
	
	public void deleteDigit() {
		String beforeDelete = this.getText();
		String afterDelete = beforeDelete.substring(0, beforeDelete.length() - 1);
		if(afterDelete.isEmpty()) {
			this.setText("0");
		} else {			
			this.setText(afterDelete);
		}
	}
	
	public String getNumber() {
		return this.getText();
	}
	
	public void resetNumber() {
		this.setText("");
	}

}
