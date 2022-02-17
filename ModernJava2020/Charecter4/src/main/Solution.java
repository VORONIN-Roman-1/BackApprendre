package main;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import main.Dish.Type;
import static java.util.stream.Collectors.toList;



public class Solution {

	public static void main(String[] args) {
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH) );
		List<Dish> list= menu.stream()
				.filter(dish->dish.getType() == Type.MEAT)
				.limit(2)
				.collect(toList());
		System.out.println(list.toString());
		
		
		//// 5.2.1!
			List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
			numbers.stream().map(n->n*n).forEach(System.out::println);
		
			//// 5.2.2!
			List<Integer> numbers1 = Arrays.asList(1, 2, 3);
			List<Integer> numbers2 = Arrays.asList(3, 4);
			List<int[]> pairs=numbers1.stream().flatMap(x->numbers2.stream().map(y-> new int[] {x, y})).collect(Collectors.toList());
			
			//5.4.3
			menu.stream()
				.filter(Dish::isVegetarian)
				.findAny()
				.ifPresent(dish -> System.out.println(dish.getName()));
			
	}

}
