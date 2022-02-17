package main;

import main.strategy.ShowStrategy;

public class ShowString {
	private ShowStrategy s;
	public void showViaStrategy(String s) {
		this.s.show(s);
	}
	public ShowStrategy getStrategy() {
		return s;
	}
	public void setStrategy(ShowStrategy strategy) {
		this.s = strategy;
	}
	
}
