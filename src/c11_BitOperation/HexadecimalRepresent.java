package c11_BitOperation;

public class HexadecimalRepresent {
    public String solve(int number) {
        StringBuilder result = new StringBuilder();
        while (number / 16 != 0) {
            result.append(hexNum(number % 16));
            number /= 16;
        }
        result.append(hexNum(number % 16));
        result.append("x0");
        return new String(result.reverse());
    }

    private char hexNum(int num) {
        return num < 10 ? (char) (num + '0') : (char) (num - 10 + 'A');
    }

    public static void main(String[] args) {
        HexadecimalRepresent test = new HexadecimalRepresent();
        System.out.println(test.solve(255));
    }
}