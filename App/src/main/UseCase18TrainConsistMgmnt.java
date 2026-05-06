package main;

public class UseCase18TrainConsistMgmnt {

    /**
     * Performs a linear search to find a bogie ID.
     * @param bogieIds Array of IDs to search through.
     * @param targetId The ID to look for.
     * @return true if found, false otherwise.
     */
    public boolean linearSearch(String[] bogieIds, String targetId) {
        if (bogieIds == null || targetId == null) {
            return false;
        }

        // Iterate through each element one by one
        for (String id : bogieIds) {
            if (id.equals(targetId)) {
                return true; // Match found, terminate search
            }
        }

        return false; // Traversed entire list without a match
    }

    public static void main(String[] args) {
        UseCase18TrainConsistMgmnt app = new UseCase18TrainConsistMgmnt();

        System.out.println("--- UC18: Linear Search for Bogie ID ---");

        String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        boolean found = app.linearSearch(consist, searchKey);

        System.out.println("Searching for: " + searchKey);
        System.out.println("Result: " + (found ? "Bogie Located" : "Bogie Not Found"));
    }
}