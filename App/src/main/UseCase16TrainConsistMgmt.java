package main;

public class UseCase16TrainConsistMgmnt {

    public void bubbleSort(int[] capacities) {
        int n = capacities.length;
        // Outer loop controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop compares adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swapping Logic using a temporary variable
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        UseCase16TrainConsistMgmnt app = new UseCase16TrainConsistMgmnt();

        System.out.println("=========================================");
        System.out.println(" UC16 Manual Sorting using Bubble Sort ");
        System.out.println("=========================================\n");

        int[] capacities = {72, 56, 24, 70, 68};[cite: 10]

        System.out.print("Original Capacities: ");
        for (int c : capacities) System.out.print(c + " ");[cite: 10]

        app.bubbleSort(capacities);

        System.out.print("\nSorted Capacities (Ascending): ");
        for (int c : capacities) System.out.print(c + " ");[cite: 10]

        System.out.println("\n\nUC16 sorting completed...");[cite: 10]
    }
}