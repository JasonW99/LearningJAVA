package c15_Probability;

public class ReservoirSampling {
    private Integer random;
    private int count;
    public ReservoirSampling() {
        this.random = null;
        this.count = 0;
    }

    public void read(int value) {
        if ((int) (Math.random() * (++count)) == 0) {
            random = (Integer) value;
        }
    }

    public Integer sample() {
        return random;
    }
}
