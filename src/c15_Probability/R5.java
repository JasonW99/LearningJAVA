package c15_Probability;

public class R5 {
    public int random5() {
        return (int) (Math.random() * 5);
    }

    public static void main(String[] args) {
        R5 test = new R5();
        System.out.print(test.random5());
    }
}
