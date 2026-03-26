import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class uniqueness {
    public static void main(String[] args) throws IOException {
        // Step 1: Read all lines from file into a List
        List<String> namesDataset = Files.readAllLines(Paths.get("name.txt"));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name: ");
        String inputName = sc.nextLine();

        // Step 2: Count occurrences
        long count = namesDataset.stream()
                .filter(name -> name.equalsIgnoreCase(inputName))
                .count();

        int totalNames = namesDataset.size();
        double uniqueness = 100 - ((double) count / totalNames * 100);

        // Step 3: Output result
        if (count == 0) {
            System.out.println("✅ This name is 100% unique!");
        } else {
            System.out.println("Uniqueness of '" + inputName + "' is: " + uniqueness + "%");
        }

        sc.close();
    }
}
