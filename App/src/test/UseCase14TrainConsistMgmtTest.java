package test;

import main.UseCase14TrainConsistMgmnt.Bogie;
import main.InvalidCapacityException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmntTest {

    @Test
    void testException_ValidCapacityCreation() {
        // Verifies that positive capacity works without issues
        assertDoesNotThrow(() -> new Bogie("Sleeper", 72));
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        // Verifies that -10 triggers the custom exception
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        // Verifies that 0 is treated as invalid
        assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Sleeper", 0);
        });
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        // Verifies data is stored correctly if validation passes
        Bogie b = new Bogie("First Class", 24);
        assertEquals(24, b.getCapacity());
    }
}