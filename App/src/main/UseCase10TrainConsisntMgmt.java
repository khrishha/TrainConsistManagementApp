package main;

import java.util.ArrayList;
import java.util.List;

public class UseCase10TrainConsistMgmnt {

    public static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() { return capacity; }
    }

    public int calculateTotalSeats(List<Bogie> bogies) {
        // Uses mapToInt to extract capacities and sum() to aggregate them
        return bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum(); // This is the aggregation step (reduce)
    }

    public static void main(String[] args) {
        UseCase10TrainConsistMgmnt app = new UseCase10TrainConsistMgmnt();

        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));
        train.add(new Bogie("AC Chair", 56));
        train.add(new Bogie("First Class", 24));

        int totalSeats = app.calculateTotalSeats(train);

        System.out.println("Total Seating Capacity: " + totalSeats);
    }
}