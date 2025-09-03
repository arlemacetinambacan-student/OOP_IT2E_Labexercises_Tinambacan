import java.util.Arrays;
import java.util.List;

public class Exer2_Declarative {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

        // Declarative: state what we want (get numbers greater than 10)
        numbers.stream()
               .filter(n -> n > 10)
               .forEach(n -> System.out.println("Number greater than 10: " + n));
    }
}
