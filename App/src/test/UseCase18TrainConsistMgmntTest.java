package test;

import main.UseCase18TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase18TrainConsistMgmntTest {

    UseCase18TrainConsistMgmnt app = new UseCase18TrainConsistMgmnt();
    String[] consist = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testSearch_BogieFound() {
        // Verifies middle element search
        assertTrue(app.linearSearch(consist, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        // Verifies result for non-existent ID
        assertFalse(app.linearSearch(consist, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        // Verifies search terminates correctly at the start
        assertTrue(app.linearSearch(consist, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        // Verifies search traverses the whole list to find the end element
        assertTrue(app.linearSearch(consist, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        // Verifies behavior with an array of size 1
        String[] single = {"BG101"};
        assertTrue(app.linearSearch(single, "BG101"));
        assertFalse(app.linearSearch(single, "BG200"));
    }
}