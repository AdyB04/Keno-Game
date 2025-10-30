import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class KenoLogic {
    private int spots;
    private int perDraw;

    public KenoLogic(int spots, int perDraw) {
        this.spots = spots;
        this.perDraw = perDraw;
    }

    public int calculatePrize(int matchCount) {
        if (spots == 1) {
            if (matchCount == 1) return 2;
        } else if (spots == 4) {
            switch (matchCount) {
                case 4: return 75;
                case 3: return 5;
                case 2: return 1;
                case 1: return 0;
                default: return 0;
            }
        } else if (spots == 8) {
            switch (matchCount) {
                case 8: return 10000;
                case 7: return 750;
                case 6: return 50;
                case 5: return 12;
                case 4: return 2;
                default: return 0;
            }
        } else if (spots == 10) {
            switch (matchCount) {
                case 10: return 100000;
                case 9: return 4250;
                case 8: return 450;
                case 7: return 40;
                case 6: return 15;
                case 5: return 2;
                case 0: return 5;
                default: return 0;
            }
        }
        return 0;
    }

    public static Set<Integer> quickPick(int spots) {
        Set<Integer> quickPicks = new HashSet<>();
        Random rand = new Random();
        while (quickPicks.size() < spots) {
            quickPicks.add(rand.nextInt(80) + 1);
        }
        return quickPicks;
    }
    public static Set<Integer> matches(Set<Integer> setOne, Set<Integer> setTwo) {
        Set<Integer> result = new HashSet<>(setOne);
        result.retainAll(setTwo);
        return result;
    }

    public static Set<Integer> randDraw() {
        Set<Integer> draw = new HashSet<>();
        Random rand = new Random();
        while (draw.size() < 20) {
            draw.add(rand.nextInt(80) + 1);
        }
        return draw;
    }
}
