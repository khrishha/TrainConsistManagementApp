package main;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class UseCase14TrainConsistMgmnt {

    public static class Bogie {
        private String type;
        private int capacity;

        public Bogie(String type, int capacity) throws InvalidCapacityException {
            // Business Rule Validation
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() { return capacity; }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempting to create a valid bogie...");
            Bogie validBogie = new Bogie("Sleeper", 72);
            System.out.println("Success! Capacity: " + validBogie.getCapacity());

            System.out.println("\nAttempting to create an invalid bogie...");
            Bogie invalidBogie = new Bogie("AC Chair", -5); // This will throw exception
        } catch (InvalidCapacityException e) {
            System.err.println("Caught Expected Error: " + e.getMessage());
        }
    }
}