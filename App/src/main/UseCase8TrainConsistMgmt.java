package main;

import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmnt {

    public static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() { return capacity; }
        public String getType() { return type; }
    }

    /**
     * Filters bogies with capacity greater than the threshold.
     */
    public List<Bogie> filterHighCapacityBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold) // The condition
                .collect(Collectors.toList());            // The result
    }
}