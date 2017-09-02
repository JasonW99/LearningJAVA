package c47_RandomLeetC;

public class RandomFromIntervalFlow {
    int count;
    Integer random = null;

    RandomFromIntervalFlow() {
        count = 0;
        random = null;
    }

    public void read(int[] input) {
        int a = input[0];
        int k = input[1] - a + 1;
        count += k;
        int currRandom = (int) (Math.random() * count);
        random = currRandom < k ? a + currRandom : random;
    }

    public Integer sample() {
        return random;
    }

    public static void main(String[] args) {
        RandomFromIntervalFlow test = new RandomFromIntervalFlow();
        System.out.println(test.sample());
        test.read(new int[] {5, 10});
        System.out.println(test.sample());
    }
}
