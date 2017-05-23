package c02_Recursion;

public class aPowerb {
    public long power(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (a == 0 || a == 1) {
            return a;
        }
        if (b % 2 == 1) {
            return power(a, b / 2) * power(a, b /2 ) * a;
        }else {
            return power(a, b / 2) * power(a, b / 2);
        }
    }

    public static void main(String[] args) {
        aPowerb test = new aPowerb();
        System.out.println(test.power(3,2));
    }
}
