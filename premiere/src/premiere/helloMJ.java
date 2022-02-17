package premiere;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class helloMJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//SORTING
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("world");
		list.add("me");
		list.add("alley");
		
		//все 4 работают
		//list.sort((x,y)->x.compareTo(y));
		list.sort(String::compareTo);
		//list.sort(Comparator.naturalOrder());
		//Collections.sort(list);
		
		System.out.println(list.toString());
		
		//показать все скрытые файлы
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		
	}

}
