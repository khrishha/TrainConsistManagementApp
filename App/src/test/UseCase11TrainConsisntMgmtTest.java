package test;

import main.UseCase11TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmntTest {

    UseCase11TrainConsistMgmnt validator = new UseCase11TrainConsistMgmnt();

    @Test
    void testRegex_ValidTrainID() {
        // Verifies correct format (TRN- followed by 4 digits) is accepted
        assertTrue(validator.validateTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        // Verifies patterns like TRAIN12 are rejected
        assertFalse(validator.validateTrainID("TRAIN12"));
        assertFalse(validator.validateTrainID("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        // Verifies that Train ID must contain exactly four digits
        assertFalse(validator.validateTrainID("TRN-123"));
        assertFalse(validator.validateTrainID("TRN-12345"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        // Verifies PET-AB returns a valid result
        assertTrue(validator.validateCargoCode("PET-AB"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        // Verifies that lowercase letters are rejected
        assertFalse(validator.validateCargoCode("pet-AB"));
        assertFalse(validator.validateCargoCode("PET-ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        // Verifies empty strings return invalid results
        assertFalse(validator.validateTrainID(""));
        assertFalse(validator.validateCargoCode(""));
    }
}