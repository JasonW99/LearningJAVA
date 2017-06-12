package c08_HashTableAndString1;

public class DetermineSubstring {
    public int solve(String large, String small) {
        if (small.length() == 0) {
            return 0;
        }
        char[] L = large.toCharArray();
        char[] S = small.toCharArray();
        for (int i = 0; i <= L.length - S.length; i++) {
            if (match(i, L, S)) {
                return i;
            }
        }
        return -1;
    }

    private boolean match(int curr, char[] large, char[] small) {
        for (int i = curr; i < curr + small.length; i++) {
            if (large[i] != small[i - curr]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineSubstring test = new DetermineSubstring();
        String large = "mississippi";
        String small = "issip";
        System.out.println(test.solve(large, small));
    }
}
