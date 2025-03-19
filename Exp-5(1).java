import java.util.List;

public class SumUsingAutoboxing {

    public static int calculateSum(List<Integer> integers) {
        int sum = 0;
        for (Integer num : integers) {
            sum += num; // Unboxing occurs here
        }
        return sum;
    }

    public static void main(String[] args) {
        List<String> stringList = List.of("5", "10", "15", "20");
        // Parse strings to Integer objects
        List<Integer> integerList = stringList.stream().map(Integer::parseInt).toList();
        
        // Calculate sum
        int sum = calculateSum(integerList);
        System.out.println("The sum is: " + sum);
    }
}
// OUTPUT
//The sum is: 50
