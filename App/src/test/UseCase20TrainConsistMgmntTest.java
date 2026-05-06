package test;

import main.UseCase20TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase20TrainConsistMgmntTest {

    UseCase20TrainConsistMgmnt app = new UseCase20TrainConsistMgmnt();

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        // Verifies that an empty array triggers the IllegalStateException
        String[] emptyArr = {};
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            app.searchWithValidation(emptyArr, "BG101");
        });

        assertEquals("Cannot search in an empty consist", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        // Verifies that search proceeds normally if data is present
        String[] data = {"BG101", "BG205"};
        assertDoesNotThrow(() -> app.searchWithValidation(data, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        // Verifies correct search result after passing the empty check
        String[] data = {"BG101", "BG205", "BG309"};
        assertTrue(app.searchWithValidation(data, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        // Verifies that false is returned if the ID is missing (but array isn't empty)
        String[] data = {"BG101", "BG205"};
        assertFalse(app.searchWithValidation(data, "BG999"));
    }
}