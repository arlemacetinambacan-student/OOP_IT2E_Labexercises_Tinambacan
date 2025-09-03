import java.util.Arrays;
import java.util.List;

public class Exer2_Imperative {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie");

        // Imperative style: step by step with explicit instructions
        for (String name : names) {
            if (name.startsWith("A")) { // check if name starts with A
                System.out.println("Name starting with A: " + name);
            }
        }
    }
}
