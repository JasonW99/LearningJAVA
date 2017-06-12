package c08_HashTableAndString1;

public class RemoveSpace {
    public String solve(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        int slow = 0;
        int fast = 0;
        char[] array = input.toCharArray();
        while (fast < array.length) {
            if (array[fast] == ' ') {
                while (fast + 1 < array.length && array[fast + 1] == ' ') {
                    fast++;
                }
            }
            array[slow++] = array[fast++];
        }
        if (array[slow - 1] == ' ') {
            slow--;
        }
        return (slow > 0 && array[0] == ' ') ? new String(array, 1, slow - 1) : new String(array, 0, slow);
    }

    public static void main(String[] args) {
        RemoveSpace test = new RemoveSpace();
        String input = " ILove Yahoo";
        System.out.println(test.solve(input));
    }
}
