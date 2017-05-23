package c02_Recursion;

public class fibonacci {
    public long solve(int K) {
        if (K <= 2) {
            return K > 0 ? 1 : 0;
        }
        long helper = 1;
        long result = 2;
        for (int i = 4; i <= K; i++) {
            result = result + helper;
            helper = result - helper;
        }
        return result;
    }

    public static void main(String[] args) {
        fibonacci test = new fibonacci();
        System.out.println(test.solve(50));
    }
}
