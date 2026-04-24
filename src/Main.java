import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String id;
    String shape; // e.g., "Cylindrical", "Box", "Flatbed"
    String cargo; // e.g., "Petroleum", "Grains", "Steel"

    public GoodsBogie(String id, String shape, String cargo) {
        this.id = id;
        this.shape = shape;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | %s]", id, shape, cargo);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC12: Safety Compliance Check ---");

        // 1. Requirement: Create a collection of goods bogies
        List<GoodsBogie> goodsTrain = new ArrayList<>();
        goodsTrain.add(new GoodsBogie("G1", "Cylindrical", "Petroleum"));
        goodsTrain.add(new GoodsBogie("G2", "Box", "Grains"));
        goodsTrain.add(new GoodsBogie("G3", "Cylindrical", "Petroleum"));
        // goodsTrain.add(new GoodsBogie("G4", "Cylindrical", "Explosives")); // Uncomment to test failure

        // 2. Requirement: Use stream() and allMatch() for validation
        // 3. Requirement: Apply logic (Cylindrical -> only Petroleum allowed)
        boolean isSafe = goodsTrain.stream().allMatch(bogie -> {
            if (bogie.shape.equalsIgnoreCase("Cylindrical")) {
                return bogie.cargo.equalsIgnoreCase("Petroleum");
            }
            return true; // Other shapes are considered safe for this check
        });

        // 4. Requirement: Store result and display compliance status
        System.out.println("Checking Train Formation: " + goodsTrain);

        if (isSafe) {
            System.out.println("\nSTATUS: ✔ Safety Compliant. The train is cleared for departure.");
        } else {
            System.out.println("\nSTATUS: ✘ SAFETY VIOLATION! Illegal cargo detected in cylindrical bogie.");
        }
    }
}