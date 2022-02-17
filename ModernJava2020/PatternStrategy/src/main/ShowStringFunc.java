package main;

import main.strategy.ShowStrategy;

public class ShowStringFunc {
	void show (String s, ShowStrategy st){
		st.show(s);
	}
}
