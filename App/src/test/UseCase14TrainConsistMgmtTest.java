package test;

import main.UseCase15TrainConsistMgmnt.GoodsBogie;
import main.CargoSafetyException;




import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmntTest {

    @Test
    void testCargo_SafeAssignment() {
        // Verifies valid combinations work
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> cylindrical.assignCargo("Petroleum"));
        assertEquals("Petroleum", cylindrical.getCargo());
    }




    @Test
    void testCargo_UnsafeAssignmentHandled() {
        // Verifies that the exception is thrown for unsafe combinations
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        assertThrows(CargoSafetyException.class, () -> {
            rectangular.assignCargo("Petroleum");
        });
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        // Verifies that the state doesn't change if an exception occurs
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        try {
            rectangular.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            // Exception caught
        }
        assertEquals("Empty", rectangular.getCargo(), "Cargo should remain 'Empty' after failed assignment");
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        // Simulates handling an error and continuing to a second valid task
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        try { b1.assignCargo("Petroleum"); } catch (Exception e) { /* Logged */ }
        
        assertDoesNotThrow(() -> b2.assignCargo("Petroleum"));
        assertEquals("Petroleum", b2.getCargo());
    }
}