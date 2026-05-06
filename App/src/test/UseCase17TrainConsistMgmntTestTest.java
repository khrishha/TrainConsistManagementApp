package main;

import java.util.Arrays;

public class UseCase17TrainConsistMgmnt {

    public String[] sortBogieNames(String[] names) {
        if (names == null || names.length == 0) {
            return names;
        }
        // Use Java's built-in optimized sorting utility
        Arrays.sort(names);
        return names;
    }

    public static void main(String[] args) {
        UseCase17TrainConsistMgmnt app = new UseCase17TrainConsistMgmnt();

        System.out.println("=========================================");
        System.out.println(" UC17 Alphabetical Sorting with Arrays.sort() ");
        System.out.println("=========================================\n");

        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        System.out.println("Original Names: " + Arrays.toString(bogieNames));

        app.sortBogieNames(bogieNames);

        System.out.println("Sorted Names:   " + Arrays.toString(bogieNames));

        System.out.println("\nUC17 alphabetical sorting completed...");
    }
}