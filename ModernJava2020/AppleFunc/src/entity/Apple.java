package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Apple {
	private Color color;
	private int weight;
	private Country country;
	
	
	{
		color = Color.GREEN;
		weight = 130;
		country = Country.France;
	}
	
	public Apple(Color color, int weight, Country country) {
		super();
		this.color = color;
		this.weight = weight;
		this.country = country;
	}

	public Apple() {
		super();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Color: "+this.color+"; weight: "+ weight+"; from "+country+ "\n";
	}
	
}
