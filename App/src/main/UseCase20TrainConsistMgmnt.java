package main;

public class UseCase20TrainConsistMgmnt {

    /**
     * Searches for a bogie ID but validates that the consist is not empty first.
     * @throws IllegalStateException if the array is empty.
     */
    public boolean searchWithValidation(String[] bogieIds, String targetId) {
        // 1. Fail-Fast Validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Cannot search in an empty consist");
        }

        // 2. Search Logic (Linear Search)
        for (String id : bogieIds) {
            if (id.equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        UseCase20TrainConsistMgmnt app = new UseCase20TrainConsistMgmnt();

        try {
            // Test case: Empty array
            String[] emptyConsist = {};
            app.searchWithValidation(emptyConsist, "BG101");
        } catch (IllegalStateException e) {
            System.err.println("Validation Error: " + e.getMessage());
        }
    }
}