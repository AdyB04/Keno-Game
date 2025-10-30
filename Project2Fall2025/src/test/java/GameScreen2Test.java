import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

public class GameScreen2Test {
    private GameScreen2 game;

    @BeforeEach
    void setup() {
        game = new GameScreen2(null, 1, 8, 1, true);
    }

    @Test
    void testCalculatePrize_Spot1Match1() {
        setPrivateField(game, "spots", 1);
        assertEquals(2, invokePrize(1));
    }

    @Test
    void testCalculatePrize_Spot1NoMatch() {
        setPrivateField(game, "spots", 1);
        assertEquals(0, invokePrize(0));
    }

    @Test
    void testCalculatePrize_Spot4Match4() {
        setPrivateField(game, "spots", 4);
        assertEquals(75, invokePrize(4));
    }

    @Test
    void testCalculatePrize_Spot4Match3() {
        setPrivateField(game, "spots", 4);
        assertEquals(5, invokePrize(3));
    }

    @Test
    void testCalculatePrize_Spot4Match2() {
        setPrivateField(game, "spots", 4);
        assertEquals(1, invokePrize(2));
    }

    @Test
    void testCalculatePrize_Spot4Match1() {
        setPrivateField(game, "spots", 4);
        assertEquals(0, invokePrize(1));
    }

    @Test
    void testCalculatePrize_Spot4Match0() {
        setPrivateField(game, "spots", 4);
        assertEquals(0, invokePrize(0));
    }

    @Test
    void testCalculatePrize_Spot8Match8() {
        setPrivateField(game, "spots", 8);
        assertEquals(10000, invokePrize(8));
    }

    @Test
    void testCalculatePrize_Spot8Match5() {
        setPrivateField(game, "spots", 8);
        assertEquals(12, invokePrize(5));
    }

    @Test
    void testCalculatePrize_Spot8Match1() {
        setPrivateField(game, "spots", 8);
        assertEquals(0, invokePrize(1));
    }

    @Test
    void testCalculatePrize_Spot10Match10() {
        setPrivateField(game, "spots", 10);
        assertEquals(100000, invokePrize(10));
    }

    @Test
    void testCalculatePrize_Spot10Match8() {
        setPrivateField(game, "spots", 10);
        assertEquals(450, invokePrize(8));
    }

    @Test
    void testCalculatePrize_Spot10Match1() {
        setPrivateField(game, "spots", 10);
        assertEquals(0, invokePrize(1));
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            fail("Could not set field '" + fieldName + "': " + e.getMessage());
        }
    }

    private int invokePrize(int matches) {
        try {
            Method method = game.getClass().getDeclaredMethod("calculatePrize", int.class);
            method.setAccessible(true);
            return (int) method.invoke(game, matches);
        } catch (Exception e) {
            fail("Failed to invoke calculatePrize: " + e.getMessage());
            return -1;
        }
    }
}
