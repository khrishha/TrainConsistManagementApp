package test;

import main.UseCase16TrainConsistMgmnt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase16TrainConsistMgmntTest {

    UseCase16TrainConsistMgmnt app = new UseCase16TrainConsistMgmnt();

    @Test
    void testSort_BasicSorting() {
        // Verifies correct sorting of a typical unsorted array[cite: 10]
        int[] capacities = {72, 56, 24, 70, 60};
        app.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);[cite: 10]
    }

    @Test
    void testSort_AlreadySortedArray() {
        // Verifies that a sorted array remains unchanged[cite: 10]
        int[] capacities = {24, 56, 60, 70, 72};
        app.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, capacities);[cite: 10]
    }

    @Test
    void testSort_DuplicateValues() {
        // Verifies handling of identical capacities[cite: 10]
        int[] capacities = {72, 56, 56, 24};
        app.bubbleSort(capacities);
        assertArrayEquals(new int[]{24, 56, 56, 72}, capacities);[cite: 10]
    }

    @Test
    void testSort_SingleElementArray() {
        // Verifies a single element does not trigger errors[cite: 10]
        int[] capacities = {50};
        app.bubbleSort(capacities);
        assertArrayEquals(new int[]{50}, capacities);[cite: 10]
    }
}