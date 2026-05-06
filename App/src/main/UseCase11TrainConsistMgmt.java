package main;

import java.util.regex.Pattern;

public class UseCase11TrainConsistMgmnt {

    // Regex Pattern: "TRN-" followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";

    // Regex Pattern: Uppercase letters, a hyphen, and more uppercase letters
    private static final String CARGO_CODE_REGEX = "^[A-Z]+-[A-Z]+$";

    public boolean validateTrainID(String trainID) {
        if (trainID == null) return false;
        return Pattern.matches(TRAIN_ID_REGEX, trainID);
    }

    public boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        return Pattern.matches(CARGO_CODE_REGEX, cargoCode);
    }

    public static void main(String[] args) {
        main.UseCase11TrainConsistMgmtTest validator = new main.UseCase11TrainConsistMgmtTest();

        System.out.println("Train ID Validation (TRN-1234): " + validator.validateTrainID("TRN-1234"));
        System.out.println("Train ID Validation (TRAIN12): " + validator.validateTrainID("TRAIN12"));
        System.out.println("Cargo Code Validation (PET-AB): " + validator.validateCargoCode("PET-AB"));
    }
}