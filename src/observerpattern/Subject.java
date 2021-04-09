package observerpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	
	private List<Observer> observers = new ArrayList<>();
	
	public void attach(Observer observer) {
		this.observers.add(observer);
	}
	
	public void detatch(Observer observer) {
		this.observers.remove(observer);
	}
	
	public void notifyObservers() {
		for(Observer observer : this.observers) {
			observer.update();
		}
	}

}
