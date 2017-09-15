package c00_HelloWorld;

import java.util.Arrays;
import java.util.Comparator;

public class SortPair {
    public int[][] sortXYPair(int[][] array) {
        Arrays.sort(array, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0]? -1: 1;
            }
        });
        return array;
    }

    public static void main(String[] args) {
        int[][] array = {{0, 1}, {-1, 2}, {1, 3}};
        SortPair test = new SortPair();
        array = test.sortXYPair(array);
        for(int[] cur: array) {
            for (int i: cur) {
                System.out.print(i);
                System.out.print(' ');
            }
            System.out.println();
        }
    }
}
