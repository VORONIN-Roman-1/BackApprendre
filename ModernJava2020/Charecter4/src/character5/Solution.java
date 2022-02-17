package character5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;

public class Solution {

  public static void main(String[] args) {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions =
        Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

    // 1
    transactions.stream().filter(tr -> tr.getYear() == 2011)
        .sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

    // 2
    transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct()
        .forEach(System.out::println);

    // 3
    transactions.stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge"))
        .distinct().sorted(comparing(Trader::getName)).forEach(System.out::println);

    // 4
    String names = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct()
        .sorted().reduce("", (x, y) -> x + y);
    System.out.println(names);

    // 5
    boolean b = transactions.stream().map(Transaction::getTrader)
        .anyMatch(t -> t.getCity().equals("Milan"));
    System.out.println(b);

    // 6
    int sum = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
        .map(Transaction::getValue).reduce(0, (x, y) -> x + y);
    System.out.println(sum);

    // 7
    int max = transactions.stream().map(Transaction::getValue).reduce(Integer::max).orElse(0);
    System.out.println(max);

    // 8
    int min =
        transactions.stream().map(Transaction::getValue).reduce((x, y) -> x > y ? y : x).orElse(0);
    System.out.println(min);
    
    ///
    String homeValue = System.getProperty("home");
    Stream<String> homeValueStream
    = homeValue == null ? Stream.empty() : Stream.of(homeValue);
    Stream<String> homeValueStream1
    = Stream.ofNullable(System.getProperty("home"));
    
    ///Fibonachi
    Stream.iterate(new int[] {0,1}, x-> new int[] {x[1], x[0]+x[1]})
    .limit(20)
    .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
  }

}
