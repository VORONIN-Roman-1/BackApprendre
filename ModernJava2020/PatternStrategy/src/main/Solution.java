package main;

import main.strategy.StrategyLower;
import main.strategy.StrategyStandart;
import main.strategy.StrategyUpper;

public class Solution {

	public static void main(String[] args) {
		
		ShowString show = new ShowString();
		show.setStrategy(new StrategyUpper());
		show.showViaStrategy("Hello");
		show.setStrategy(new StrategyLower());
		show.showViaStrategy("Hello");
		show.setStrategy(new StrategyStandart());
		show.showViaStrategy("Hello");
		
		
		ShowStringFunc showFunc = new ShowStringFunc();
		showFunc.show("Salut", new StrategyUpper());
		showFunc.show("Salut", new StrategyLower());
		showFunc.show("Salut", new StrategyStandart());
		showFunc.show("Salut", x-> System.out.println(x.toUpperCase()+" "+ x.toLowerCase()));
	}

}
