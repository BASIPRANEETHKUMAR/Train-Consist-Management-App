import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Requirement: Create a Bogie class with fields name and capacity
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    @Override
    public String toString() {
        return String.format("Bogie: %-15s | Capacity: %d seats", name, capacity);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");

        // Requirement: Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // Requirement: Add bogies with different capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair Car", 56));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("General", 90));

        System.out.println("\nBefore Sorting (Insertion Order):");
        passengerBogies.forEach(System.out::println);

        // Requirement: Use Comparator.comparingInt() to define sorting
        // Lambda Expression used for concise comparison logic
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // Requirement: Sort the list and display the sorted bogies
        System.out.println("\nAfter Sorting (By Capacity - Ascending):");
        for (Bogie b : passengerBogies) {
            System.out.println(b);
        }
    }
}


