import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class KenoLogicTest {
    @Test
    void testSpot4Match4() {
        KenoLogic logic = new KenoLogic(4, 1);
        assertEquals(75, logic.calculatePrize(4));
    }

    @Test
    void testSpot10Match0() {
        KenoLogic logic = new KenoLogic(10, 1);
        assertEquals(5, logic.calculatePrize(0));
    }

    @Test
    void testSpot8Match7() {
        KenoLogic logic = new KenoLogic(8, 1);
        assertEquals(750, logic.calculatePrize(7));
    }

    @Test
    void testSpot1Match1() {
        KenoLogic logic = new KenoLogic(1, 1);
        assertEquals(2, logic.calculatePrize(1));
    }

    @Test
    void quickPickSize8() {
        Set<Integer> quickPicks = KenoLogic.quickPick(8);
        assertEquals(8, quickPicks.size(), "Wrong number of spots, should be 8");
    }

    @Test
    void quickPickSize4() {
        Set<Integer> quickPicks = KenoLogic.quickPick(4);
        assertEquals(4, quickPicks.size(), "Wrong number of spots, should be 4");
    }

    @Test
    void findMatches1() {
        Set<Integer> setOne = Set.of(1, 2, 3, 4, 5);
        Set<Integer> setTwo = Set.of(2, 4, 6, 8, 10);
        Set<Integer> getMatches = KenoLogic.matches(setOne, setTwo);
        assertEquals(Set.of(2,4), getMatches, "matches should be 2 and 4");
    }

    @Test
    void findMatches2() {
        Set<Integer> setOne = Set.of(1, 2, 3, 4, 5);
        Set<Integer> setTwo = Set.of(1, 2, 3, 4, 10);
        Set<Integer> getMatches = KenoLogic.matches(setOne, setTwo);
        assertEquals(Set.of(1,2,3,4), getMatches, "matches should be 1, 2, 3, 4");
    }

    @Test
    void findMatches3() {
        Set<Integer> setOne = Set.of(1, 2, 3, 4, 5);
        Set<Integer> setTwo = Set.of(6, 7, 8, 9, 10);
        Set<Integer> getMatches = KenoLogic.matches(setOne, setTwo);
        assertTrue(getMatches.isEmpty(), "matches should be empty");
    }
}
