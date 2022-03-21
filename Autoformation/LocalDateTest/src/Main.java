import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        LocalDate localDateNow = LocalDate.now();
        LocalDate dateDeNaissance =  LocalDate.of(2012,03,12);
        System.out.println(Period.between(localDateNow, dateDeNaissance));
    }
}
