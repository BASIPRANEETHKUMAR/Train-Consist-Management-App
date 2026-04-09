import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC5: Preserve Insertion Order (LinkedHashSet) ---");

        // Requirement: Create a LinkedHashSet to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Requirement: Attach initial bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Current Formation: " + trainFormation);

        // Requirement: Attempt to attach a duplicate bogie intentionally
        System.out.println("\nAttempting to re-attach: Sleeper...");
        boolean isAdded = trainFormation.add("Sleeper");

        if (!isAdded) {
            System.out.println("Action Ignored: Sleeper is already part of the formation.");
        }

        // Requirement: Display the final formation order
        // Requirement: Ensure duplicates do not appear
        System.out.println("\nFinal Train Formation (Unique & Ordered):");
        System.out.println(trainFormation);

        // Demonstrating Ordered Iteration
        System.out.print("Physical Sequence: ");
        for (String bogie : trainFormation) {
            System.out.print("[" + bogie + "] -> ");
        }
        System.out.println("END");
    }
}
