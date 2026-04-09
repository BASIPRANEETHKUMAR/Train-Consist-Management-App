import java.util.LinkedList;
import java.util.Scanner;

// Model class representing a single Coach
class Coach {
    private String id;
    private String type; // e.g., AC, Sleeper, Pantry

    public Coach(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        return "[" + id + " | " + type + "]";
    }
}

// Manager class handling the Train Consist logic
class TrainConsistManager {
    // We use LinkedList for O(1) insertions at head/tail and efficient reordering
    private LinkedList<Coach> consist = new LinkedList<>();

    // Logic: Prevention of duplication (Validation)
    public boolean addCoach(String id, String type) {
        for (Coach c : consist) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("Error: Coach ID " + id + " already exists in the consist.");
                return false;
            }
        }
        consist.add(new Coach(id, type));
        return true;
    }

    public void displayConsist() {
        if (consist.isEmpty()) {
            System.out.println("The train consist is currently empty.");
        } else {
            System.out.print("Engine <-> ");
            for (Coach c : consist) {
                System.out.print(c + " <-> ");
            }
            System.out.println("End");
        }
    }

    public void removeLastCoach() {
        if (!consist.isEmpty()) {
            Coach removed = consist.removeLast();
            System.out.println("Removed: " + removed);
        }
    }
}

public class TrainApp {
    public static void main(String[] args) {
        TrainConsistManager manager = new TrainConsistManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Train Consist Management System ---");

        // Simulating incremental operational additions
        manager.addCoach("A1", "AC First Class");
        manager.addCoach("B1", "Sleeper");
        manager.addCoach("P1", "Pantry Car");

        manager.displayConsist();

        // Demonstrating validation logic (Duplicate ID)
        System.out.println("\nAttempting to add duplicate coach (A1)...");
        manager.addCoach("A1", "AC Second Class");

        System.out.println("\nFinal Train Configuration:");
        manager.displayConsist();
    }
}