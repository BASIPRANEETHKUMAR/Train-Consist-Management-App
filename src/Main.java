import java.util.ArrayList;
import java.util.List;

// Requirement: Create a custom exception class InvalidCapacityException
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

class PassengerBogie {
    private String id;
    private int capacity;

    // Requirement: Validate capacity inside the constructor
    // Requirement: Declare the constructor with throws InvalidCapacityException
    public PassengerBogie(String id, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            // Requirement: Throw the exception when capacity is <= 0
            throw new InvalidCapacityException("Invalid Capacity: " + capacity +
                    ". Bogie " + id + " must have a positive seating capacity.");
        }
        this.id = id;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bogie[" + id + " | Capacity: " + capacity + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- UC14: Custom Exception Handling ---");
        List<PassengerBogie> trainConsist = new ArrayList<>();

        // Test Case 1: Valid Bogie
        try {
            PassengerBogie b1 = new PassengerBogie("S1", 72);
            trainConsist.add(b1);
            System.out.println("Successfully added: " + b1);
        } catch (InvalidCapacityException e) {
            System.err.println(e.getMessage());
        }

        // Test Case 2: Invalid Bogie (Zero Capacity)
        // Requirement: Ensure invalid bogies are never added to the consist
        try {
            System.out.println("\nAttempting to add invalid bogie (Capacity 0)...");
            PassengerBogie b2 = new PassengerBogie("S2", 0);
            trainConsist.add(b2);
        } catch (InvalidCapacityException e) {
            System.out.println("Validation Failed: " + e.getMessage());
        }

        System.out.println("\nFinal Valid Train Consist: " + trainConsist);
    }
}