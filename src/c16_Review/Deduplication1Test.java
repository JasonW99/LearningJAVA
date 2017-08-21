package c16_Review;

import static org.junit.Assert.*;

public class Deduplication1Test {
    @org.junit.Test
    public void test1() throws Exception {
        Deduplication1 test = new Deduplication1();
        int[] input = {2, 3, 3, 4, 4};
        int[] result = {2, 3, 4};
        assertArrayEquals(test.solve(input), result);
    }

    @org.junit.Test
    public void test2() throws Exception {
        Deduplication1 test = new Deduplication1();
        int[] input = {2, 3, 3, 4};
        int[] result = {2, 3, 4};
        assertArrayEquals(test.solve(input), result);
    }

    @org.junit.Test
    public void test3() throws Exception {
        Deduplication1 test = new Deduplication1();
        int[] input = {2, 3, 3, 3, 4};
        int[] result = {2, 3, 4};
        assertArrayEquals(test.solve(input), result);
    }
}