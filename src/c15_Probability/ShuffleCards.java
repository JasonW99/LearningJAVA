package c15_Probability;


public class ShuffleCards {
    public void solve(int[] array) {
        if (array.length <= 1) {
            return;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, (int) (Math.random() * (i + 1)));
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
