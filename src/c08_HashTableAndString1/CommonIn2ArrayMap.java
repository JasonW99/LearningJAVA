package c08_HashTableAndString1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonIn2ArrayMap {
    public List<Integer> solve(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer a : A) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        for (Integer b : B){
            Integer num = map.get(b);
            if (num != null && num > 0) {
                result.add(b);
                map.put(b, map.get(b) - 1);
            }
        }
        return result;
    }
}
