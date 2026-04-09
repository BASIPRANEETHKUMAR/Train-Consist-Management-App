import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // UC1 & UC2 logic consolidated into UC3
        System.out.println("--- Train Bogie Tracker (Unique IDs) ---");

        // Key Concept: Set Interface & HashSet Implementation
        Set<String> bogieIds = new HashSet<>();

        // Flow: User adds bogie IDs
        addBogie(bogieIds, "B1");
        addBogie(bogieIds, "A1");
        addBogie(bogieIds, "B2");

        // Flow: Duplicates are ignored
        System.out.println("\nAttempting to add duplicate Bogie ID: B1...");
        addBogie(bogieIds, "B1");

        // Flow: Unique IDs are displayed
        System.out.println("\nFinal Unique Bogie List:");
        System.out.println(bogieIds);
        System.out.println("Total Unique Bogies: " + bogieIds.size());
    }

    /**
     * Helper method to demonstrate 'add()' and 'Automatic Deduplication'
     */
    private static void addBogie(Set<String> set, String id) {
        if (set.add(id)) {
            System.out.println("Successfully added Bogie: " + id);
        } else {
            System.out.println("Rejected: Bogie ID " + id + " already exists!");
        }
    }
}