package main.strategy;

public class StrategyUpper implements ShowStrategy {

	@Override
	public void show(String s) {
		System.out.println(s.toUpperCase());
		
	}

}
