// O(n!)

import java.util.ArrayList;
import java.util.List;

public class FactorialTime {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8); // Larger input will take excessive time
        List<List<Integer>> permutations = new ArrayList<>();
        
        long startTime = System.nanoTime(); // Start time
        
        permute(new ArrayList<>(), numbers, permutations); // O(n!)
        
        long endTime = System.nanoTime(); // End time
        System.out.println("Total permutations: " + permutations.size());
        System.out.println("Execution time (ns): " + (endTime - startTime));
    }

    private static void permute(List<Integer> prefix, List<Integer> remaining, List<List<Integer>> result) {
        if (remaining.isEmpty()) {
            result.add(new ArrayList<>(prefix));
        } else {
            for (int i = 0; i < remaining.size(); i++) {
                List<Integer> newPrefix = new ArrayList<>(prefix);
                newPrefix.add(remaining.get(i));
                
                List<Integer> newRemaining = new ArrayList<>(remaining);
                newRemaining.remove(i);
                
                permute(newPrefix, newRemaining, result);
            }
        }
    }
}

