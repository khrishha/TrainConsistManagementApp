package test;

import main.UseCase13PerformanceComp;
import main.UseCase13PerformanceComp.Bogie;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class UseCase13PerformanceCompTest {

    @Test
    public void testExecutionTimeMeasurement() {
        UseCase13PerformanceComp app = new UseCase13PerformanceComp();
        List<Bogie> bogies = new ArrayList<>();
        for(int i = 0; i < 1000; i++) bogies.add(new Bogie(70));

        // Verify that elapsed time is a positive value [cite: 73]
        long loopTime = app.runLoopFiltering(bogies);
        long streamTime = app.runStreamFiltering(bogies);

        assertTrue(loopTime > 0, "Loop execution time should be greater than zero");
        assertTrue(streamTime > 0, "Stream execution time should be greater than zero");

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");
    }

    @Test
    public void testLargeDatasetProcessing() {
        UseCase13PerformanceComp app = new UseCase13PerformanceComp();
        List<Bogie> bogies = new ArrayList<>();
        // Simulate a large dataset [cite: 64, 74]
        for(int i = 0; i < 10000; i++) {
            bogies.add(new Bogie(i % 100));
        }

        long loopTime = app.runLoopFiltering(bogies);
        assertDoesNotThrow(() -> app.runStreamFiltering(bogies));
        System.out.println("Large Dataset Loop Time: " + loopTime + " ns");
    }
}