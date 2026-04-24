import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Bogie {
    String name;
    String type; // New field for classification: e.g., "Passenger", "Freight"
    int capacity;

    public Bogie(String name, String type, int capacity) {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() { return type; }

    @Override
    public String toString() {
        return String.format("[%s | Cap: %d]", name, capacity);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC9: Group Bogies by Type ---");

        // 1. Requirement: Reuse/Create the list of Bogie objects
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper 1", "Passenger", 72));
        bogies.add(new Bogie("AC Coach 1", "Passenger", 56));
        bogies.add(new Bogie("Coal Wagon", "Freight", 100));
        bogies.add(new Bogie("Sleeper 2", "Passenger", 72));
        bogies.add(new Bogie("Oil Tanker", "Freight", 80));

        // 2. Requirement: Create a stream and apply Collectors.groupingBy()
        // 3. Requirement: Store result in Map<String, List<Bogie>>
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        // 4. Requirement: Print the grouped bogie structure
        System.out.println("\n--- Categorized Bogie Report ---");
        groupedBogies.forEach((category, list) -> {
            System.out.println("Category: " + category);
            System.out.println("  Bogies: " + list);
            System.out.println("  Count:  " + list.size());
            System.out.println();
        });
    }
}