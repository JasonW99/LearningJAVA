package c15_Probability;

/**
public class R1000UsingR5 {
    private R5 RandomFive = new R5();
    public int delete() {
        int propose = 3000;
        while (propose > 2999) {
            propose = 625 * RandomFive.random5() + 125 * RandomFive.random5() + 25 * RandomFive.random5() + 5 * RandomFive.random5() + RandomFive.random5();
        }
        return propose % 1000;
    }
}
**/

public class R1000UsingR5 {
    private R5 RandomFive = new R5();
    public int solve() {
        while (true) {
            int propose = 0;
            for (int i = 0; i < 5; i++) {
                propose += 5 * propose + RandomFive.random5();
            }
            if (propose < 3000) {
                return propose % 1000;
            }
        }
    }
}