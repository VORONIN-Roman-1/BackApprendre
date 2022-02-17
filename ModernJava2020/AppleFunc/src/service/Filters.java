package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import entity.Apple;

public class Filters {
	public static <T> List<T> filterSimpleColor(List<T> list, Predicate<T> p){
		List<T> result= new ArrayList<>();
		for (T apple : list) {
			if (p.test(apple)) result.add(apple);
		}
		 return result;
	};

	public static void prettyPrintApple(List<Apple> inventory, Function<Apple, String> func) {
		for(Apple apple: inventory) {
			
			String output = func.apply(apple);
			System.out.println(output);
			}
			}
}
