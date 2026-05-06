package test;

import main.UseCase8TrainConsistMgmnt;
import main.UseCase8TrainConsistMgmnt.Bogie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmntTest {

    UseCase8TrainConsistMgmnt app = new UseCase8TrainConsistMgmnt();

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Verifies that bogies meeting the condition are included
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 72), new Bogie("AC", 50));
        List<Bogie> result = app.filterHighCapacityBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals(72, result.get(0).getCapacity());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        // Verifies result is empty when no bogies meet the threshold
        List<Bogie> bogies = List.of(new Bogie("First Class", 24));
        List<Bogie> result = app.filterHighCapacityBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_EmptyBogieList() {
        // Verifies that filtering an empty list doesn't crash the app
        List<Bogie> result = app.filterHighCapacityBogies(new ArrayList<>(), 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        // Verifies the source list remains intact (Immutability)
        List<Bogie> bogies = new ArrayList<>(List.of(new Bogie("Sleeper", 72)));
        app.filterHighCapacityBogies(bogies, 70);

        assertEquals(1, bogies.size(), "Original list size should not change");
    }
}