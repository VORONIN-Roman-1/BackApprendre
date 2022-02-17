package character6;
import static java.util.Arrays.asList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import character6.Dish.Type;
import static java.util.stream.Collectors.toList;
import java.util.Arrays;
import static java.util.stream.Collectors.*;


enum CaloricLevel { DIET, NORMAL, FAT }
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
		
		Map<String, List<String>> dishTags = new HashMap<>();
		dishTags.put("pork", asList("greasy", "salty"));
		dishTags.put("beef", asList("salty", "roasted"));
		dishTags.put("chicken", asList("fried", "crisp"));
		dishTags.put("french fries", asList("greasy", "fried"));
		dishTags.put("rice", asList("light", "natural"));
		dishTags.put("season fruit", asList("fresh", "natural"));
		dishTags.put("pizza", asList("tasty", "salty"));
		dishTags.put("prawns", asList("tasty", "roasted"));
		dishTags.put("salmon", asList("delicious", "fresh"));
		
		Map<Dish.Type, List<Dish>> caloricDishesByType =
		    menu.stream()
		    .collect(groupingBy(Dish::getType,
		    filtering(dish -> dish.getCalories() > 500, toList())));
		
		Map<Dish.Type, Set<String>> dishNamesByType =
		    menu.stream()
		    .collect(groupingBy(Dish::getType,
		    flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
		    toSet())));
		
		Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType =
		    menu.stream().collect(
		    groupingBy(Dish::getType, mapping(dish -> {
		    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
		    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
		    else return CaloricLevel.FAT; },
		    toSet() )));
		
		String hello="Hello  AOrld";
		long count=hello.lines().flatMap(x->Arrays.asList(x.split(" ")).stream()).filter(Predicate.not(String::isBlank)).count();
		System.out.println(count);
	System.out.println(caloricLevelsByType);
	}

}
