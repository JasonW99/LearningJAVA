package c11_BitOperation;

public class AllUniqueChar {
    public boolean solve(String word) {
        if (word.length() <= 1) {
            return true;
        }
        int[] flag = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i);
            int shift1k = 1 << curr % 32;
            if ((flag[curr / 32] & shift1k) != 0) {
                return false;
            } else {
                flag[curr / 32] |= shift1k;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AllUniqueChar test = new AllUniqueChar();
        System.out.println(test.solve("ABCDjdso390"));
    }
}
