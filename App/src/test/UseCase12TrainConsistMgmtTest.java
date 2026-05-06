package test;

import main.UseCase12TrainConsistMgmnt;
import main.UseCase12TrainConsistMgmnt.GoodsBogie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase12TrainConsistMgmntTest {

    UseCase12TrainConsistMgmnt app = new UseCase12TrainConsistMgmnt();

    @Test
    void testSafety_AllBogiesValid() {
        // Verifies train is safe when cylindrical bogies carry Petroleum[cite: 7]
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        assertTrue(app.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        // Verifies cylindrical bogies carrying Coal fail validation[cite: 7]
        List<GoodsBogie> bogies = List.of(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(app.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        // Verifies Open or Box bogies can carry any cargo[cite: 7]
        List<GoodsBogie> bogies = List.of(new GoodsBogie("Open", "Grain"));
        assertTrue(app.checkSafetyCompliance(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        // Verifies empty list is safe as no violations exist[cite: 7]
        assertTrue(app.checkSafetyCompliance(new ArrayList<>()));
    }
}