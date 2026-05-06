package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase13PerformanceComp {

    public static class Bogie {
        int capacity;
        public Bogie(int capacity) { this.capacity = capacity; }
        public int getCapacity() { return capacity; }
    }

    // Loop-Based Filtering
    public long runLoopFiltering(List<Bogie> bogies) {
        long startTime = System.nanoTime(); // [cite: 43]
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        long endTime = System.nanoTime(); // [cite: 47]
        return endTime - startTime; // [cite: 48]
    }

    // Stream-Based Filtering
    public long runStreamFiltering(List<Bogie> bogies) {
        long startTime = System.nanoTime(); // [cite: 43]
        List<Bogie> result = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endTime = System.nanoTime(); // [cite: 47]
        return endTime - startTime; // [cite: 48]
    }
}