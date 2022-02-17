package main.strategy;

public class StrategyLower implements ShowStrategy {

	@Override
	public void show(String s) {
		System.out.println(s.toLowerCase());
		
	}

}
