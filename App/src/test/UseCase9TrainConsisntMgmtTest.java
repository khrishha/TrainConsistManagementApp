package test;

import main.UseCase9TrainConsistMgmnt.Bogie;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmntTest {

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Verifies that bogies are correctly grouped based on their type
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("AC Chair").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        // Verifies that grouping an empty list returns an empty Map
        List<Bogie> bogies = new ArrayList<>();
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        // Verifies original list remains unchanged after grouping
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int originalSize = bogies.size();

        bogies.stream().collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(originalSize, bogies.size());
    }
}