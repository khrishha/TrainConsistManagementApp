package test;

import main.UseCase19TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase19TrainConsistMgmntTest {

    UseCase19TrainConsistMgmnt app = new UseCase19TrainConsistMgmnt();
    String[] sortedIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

    @Test
    void testBinarySearch_BogieFound() {
        // Verifies middle-range search
        assertTrue(app.binarySearch(sortedIds, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        // Verifies negative result for non-existent ID
        assertFalse(app.binarySearch(sortedIds, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        // Verifies search works at the lower boundary
        assertTrue(app.binarySearch(sortedIds, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        // Verifies search works at the upper boundary
        assertTrue(app.binarySearch(sortedIds, "BG550"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        // Verifies safety with an empty list
        assertFalse(app.binarySearch(new String[]{}, "BG101"));
    }
}