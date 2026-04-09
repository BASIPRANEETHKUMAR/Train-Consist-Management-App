import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("--- UC6: Map Bogie to Capacity (HashMap) ---");

        // Requirement: Create a HashMap<String, Integer> for bogie-capacity info
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Requirement: Use put() to map bogies to their capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair Car", 56);
        bogieCapacityMap.put("First Class", 24);
        bogieCapacityMap.put("General", 90);

        // Requirement: Iterate over the map using entrySet()
        System.out.println("Bogie Capacity Details:");
        System.out.println("----------------------------");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            // Requirement: Display each bogie along with its corresponding capacity
            System.out.println("Bogie Type: " + entry.getKey() + " | Capacity: " + entry.getValue() + " seats");
        }

        // Key Benefit: Fast Lookup
        String searchType = "AC Chair Car";
        System.out.println("\nFast Lookup for [" + searchType + "]: " + bogieCapacityMap.get(searchType) + " seats");
    }
}
