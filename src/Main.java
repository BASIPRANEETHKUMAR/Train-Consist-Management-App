import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC8: Filter Bogies Using Streams ---");

        // 1. Requirement: Reuse/Create the Bogie list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair Car", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies: " + bogies);

        // 2. Requirement: Create a stream and apply filter (capacity > 60)
        // 3. Requirement: Collect the result into a new list
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // 4. Requirement: Display the filtered bogies
        System.out.println("\n--- High Capacity Bogies ( > 60 seats ) ---");
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }
    }
}