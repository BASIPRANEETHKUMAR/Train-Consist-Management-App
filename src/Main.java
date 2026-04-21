import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    String id;
    int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Requirement: Create a collection of bogies for testing
        List<Bogie> largeConsist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeConsist.add(new Bogie("B-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("--- UC13: Performance Comparison (Loops vs Streams) ---");

        // --- LOOP BASED PROCESSING ---
        long startLoop = System.nanoTime(); // Requirement: Capture start time
        List<Bogie> filteredLoop = new ArrayList<>();
        for (Bogie b : largeConsist) {
            if (b.capacity > 50) {
                filteredLoop.add(b);
            }
        }
        long endLoop = System.nanoTime(); // Requirement: Capture end time
        long loopDuration = endLoop - startLoop;

        // --- STREAM BASED PROCESSING ---
        long startStream = System.nanoTime();
        List<Bogie> filteredStream = largeConsist.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 2. Requirement: Print the execution duration
        System.out.println("Loop Processing Time   : " + loopDuration + " ns");
        System.out.println("Stream Processing Time : " + streamDuration + " ns");

        double difference = (double) (streamDuration - loopDuration) / loopDuration * 100;
        System.out.printf("Difference: Streams are %.2f%% slower/faster in this micro-benchmark.\n", difference);
    }
}