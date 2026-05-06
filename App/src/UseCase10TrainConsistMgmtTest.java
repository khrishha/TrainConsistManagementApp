package test;

import main.UseCase10TrainConsistMgmnt;
import main.UseCase10TrainConsistMgmnt.Bogie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmntTest {

    @Test
    void testReduce_AllBogiesIncluded() {
        // Verifies that all bogie capacities contribute to the final total
        UseCase10TrainConsistMgmnt app = new UseCase10TrainConsistMgmnt();
        List<Bogie> bogies = List.of(new Bogie("Sleeper", 72), new Bogie("AC", 50));

        assertEquals(122, app.calculateTotalSeats(bogies));
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Verifies that aggregation on an empty list returns 0
        UseCase10TrainConsistMgmnt app = new UseCase10TrainConsistMgmnt();
        List<Bogie> emptyList = new ArrayList<>();

        assertEquals(0, app.calculateTotalSeats(emptyList));
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Verifies total equals the single bogie's capacity
        UseCase10TrainConsistMgmnt app = new UseCase10TrainConsistMgmnt();
        List<Bogie> oneBogie = List.of(new Bogie("Sleeper", 72));

        assertEquals(72, app.calculateTotalSeats(oneBogie));
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Verifies the original list is not modified during stream processing
        UseCase10TrainConsistMgmnt app = new UseCase10TrainConsistMgmnt();
        List<Bogie> bogies = new ArrayList<>(List.of(new Bogie("Sleeper", 72)));

        app.calculateTotalSeats(bogies);
        assertEquals(1, bogies.size());
    }
}