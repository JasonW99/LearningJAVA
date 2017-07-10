package c12_DynamicProgramming01;

public class ArrayHoperI {
    public boolean solve(int[] array) {
        boolean[] result = new boolean[array.length];
        result[0] = true;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && j + array[j] >= i) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[array.length - 1];
    }
}
