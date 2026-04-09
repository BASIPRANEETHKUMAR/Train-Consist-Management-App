import java.util.ArrayList;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC10: Total Seating Capacity (Stream Reduction) ---");

        // 1. Requirement: Reuse/Create the list of Bogie objects
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper 1", 72));
        train.add(new Bogie("Sleeper 2", 72));
        train.add(new Bogie("AC Chair Car", 56));
        train.add(new Bogie("First Class", 24));
        train.add(new Bogie("General", 90));

        // 2. Requirement: Create stream, map to capacity, and reduce to sum
        // reduce(identity, accumulator) -> 0 is the starting total
        int totalSeats = train.stream()
                .map(Bogie::getCapacity)        // Extracts numeric values
                .reduce(0, Integer::sum);       // Sums them all up

        // 3. Requirement: Display the total seating capacity
        System.out.println("Total Bogies in Train: " + train.size());
        System.out.println("Combined Seating Capacity: " + totalSeats + " passengers");

        // Functional Analytics Tip:
        // You can also use .mapToInt(Bogie::getCapacity).sum() for primitive efficiency!
    }
}