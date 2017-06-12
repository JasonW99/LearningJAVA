package c08_HashTableAndString1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonIn2SortedArrayIndex {
    public List<Integer> solve(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || B == null || A.size() == 0 || B.size() == 0) {
            return result;
        }
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) == B.get(j)) {
                result.add(A.get(i));
                i++;
                j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CommonIn2SortedArrayIndex test = new CommonIn2SortedArrayIndex();
        List<Integer> A = Arrays.asList(1,2,3,4,5,6);
        List<Integer> B = Arrays.asList(1,3,3,3);
        List<Integer> result = test.solve(A, B);
        for (Integer curr : result) {
            System.out.println(curr);
        }
    }
}
