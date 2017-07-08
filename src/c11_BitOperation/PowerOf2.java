package c11_BitOperation;

public class PowerOf2 {
    public boolean solve1(int number) {
        if (number <= 0) {
            return false;
        }
        return (number & (number - 1)) == 0;
    }

    public boolean solve2(int number) {
        if (number <= 0) {
            return false;
        }
        while ((number & 1) == 0) {
            number >>>= 1;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        PowerOf2 test = new PowerOf2();
        System.out.println(test.solve1(8));
        System.out.println(test.solve2(8));
    }
}
