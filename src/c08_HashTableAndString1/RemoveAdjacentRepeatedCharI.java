package c08_HashTableAndString1;


public class RemoveAdjacentRepeatedCharI {
    public String solve(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow]) {
                array[++slow] = array[fast];
            }
        }
        return new String(array, 0, slow + 1);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharI test = new RemoveAdjacentRepeatedCharI();
        String input = "aaabbbc";
        System.out.println(test.solve(input));
    }
}
