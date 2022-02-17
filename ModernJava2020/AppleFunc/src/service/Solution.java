package service;

import java.util.List;

import entity.Apple;

public class Solution {
	public static void main ( String args[] ) {
		System.out.println("hello");
		
		List <Apple> list = Factory.GenerateutFruit(100, 300, Apple::new);
		List <Apple> list2 = Factory.GenerateutFruit(100, 300, (a,b,c)-> new Apple(a,b,c));
		
//		System.out.println(list.toString());
//		System.out.println(Filters.filterSimpleColor(list, x->x.getColor()==Color.GREEN).toString());
//		System.out.println(Filters.filterSimpleColor(list, x->x.getWeight()>150).toString());
//		System.out.println(Filters.filterSimpleColor(list, x->x.getWeight()>150 && x.getColor()==Color.GREEN ).toString());
//		System.out.println(Filters.filterSimpleColor(list,
//				x->{
//					System.out.print("result"); 
//					if (x.getWeight()<100 && x.getColor()==Color.RED)
//						return true;
//					return false;} ).toString());
		Filters.prettyPrintApple(list, x->"COLOR: "+x.getColor()+ " WEIGHT:"+x.getWeight());
		Filters.prettyPrintApple(list2, x->"COLOR2: "+x.getColor()+ " WEIGHT2:"+x.getWeight());
	}
}
