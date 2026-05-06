package main;

import java.util.Arrays;

public class UseCase19TrainConsistMgmnt {

    /**
     * Performs a binary search on a sorted array of Bogie IDs.
     * @param sortedBogieIds Array of IDs (MUST be sorted).
     * @param targetId The ID to find.
     * @return true if found, false otherwise.
     */
    public boolean binarySearch(String[] sortedBogieIds, String targetId) {
        if (sortedBogieIds == null || targetId == null) return false;

        int low = 0;
        int high = sortedBogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Find the middle index
            int comparison = targetId.compareTo(sortedBogieIds[mid]);

            if (comparison == 0) {
                return true; // Match found!
            } else if (comparison < 0) {
                high = mid - 1; // Target is in the left half
            } else {
                low = mid + 1; // Target is in the right half
            }
        }

        return false; // Target not found
    }

    public static void main(String[] args) {
        UseCase19TrainConsistMgmnt app = new UseCase19TrainConsistMgmnt();

        // Binary search requires sorted data
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG412";

        System.out.println("--- UC19: Optimized Binary Search ---");
        System.out.println("Sorted Consist: " + Arrays.toString(bogieIds));

        boolean found = app.binarySearch(bogieIds, searchKey);
        System.out.println("Searching for " + searchKey + ": " + (found ? "Found" : "Not Found"));
    }
}