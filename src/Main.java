import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC4: Maintain Ordered Bogie IDs ---");

        // Requirement: Create a LinkedList for the consist
        LinkedList<String> consist = new LinkedList<>();

        // Requirement: Add initial bogies
        // Using addLast() to ensure they follow the sequence: Engine -> Sleeper -> ...
        consist.add("Engine");
        consist.add("Sleeper");
        consist.add("AC");
        consist.add("Cargo");
        consist.add("Guard");

        System.out.println("Initial Consist: " + consist);

        // Requirement: Insert a Pantry Car at position 2 (Index 2)
        // LinkedList makes this efficient by re-linking nodes
        consist.add(2, "Pantry Car");
        System.out.println("After Adding Pantry Car: " + consist);

        // Requirement: Remove the first and last bogie
        String removedFirst = consist.removeFirst();
        String removedLast = consist.removeLast();

        System.out.println("\nDetached Head: " + removedFirst);
        System.out.println("Detached Tail: " + removedLast);

        // Requirement: Display the final ordered train consist
        System.out.println("\nFinal Ordered Train Consist:");
        displayTrain(consist);
    }

    private static void displayTrain(LinkedList<String> list) {
        System.out.print("TRACK: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i) + "]");
            if (i < list.size() - 1) System.out.print(" <-> ");
        }
        System.out.println();
    }
}