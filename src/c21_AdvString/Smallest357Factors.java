package c21_AdvString;

import java.util.*;

//public class Smallest357Factors {
//    public long solve(int k) {
//        PriorityQueue<Long> minHeap = new PriorityQueue<>();
//        Set<Long> visited = new HashSet<>();
//        minHeap.offer(3 * 5 * 7L);
//        visited.add(3 * 5 * 7L);
//        while (k > 1) {
//            long result = minHeap.poll();
//            if (visited.add(result *3 )) {
//                minHeap.offer(result * 3);
//            }
//            if (visited.add(result * 5)) {
//                minHeap.offer(result *5);
//            }
//            if (visited.add(result * 7)) {
//                minHeap.offer(result * 7);
//            }
//            k--;
//        }
//        return minHeap.peek();
//    }
//}

public class Smallest357Factors {
    public long solve(int k) {
        long result = 3 * 5 * 7;
        Deque<Long> queue3 = new LinkedList<>();
        Deque<Long> queue5 = new LinkedList<>();
        Deque<Long> queue7 = new LinkedList<>();
        queue3.offer(result * 3);
        queue5.offer(result * 5);
        queue7.offer(result * 7);
        while (k > 1) {
            if (queue7.peek() < queue5.peek() && queue7.peek() < queue3.peek()) {
                result = queue7.poll();
                queue7.offer(result * 7);
            } else if (queue5.peek() < queue7.peek() && queue5.peek() < queue3.peek()) {
                result = queue5.poll();
                queue5.offer(result * 5);
                queue7.offer(result * 7);
            } else {
                result = queue3.poll();
                queue3.offer(result * 3);
                queue5.offer(result * 5);
                queue7.offer(result * 7);
            }
            k--;
        }
        return result;
    }
}



/**
public class Solution {

    static class Element {
        int three;
        int five;
        int seven;

        Element(int three, int five, int seven) {
            this.three = three;
            this.five = five;
            this.seven = seven;
        }
    }

    public long kth(int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                long value1 = calculate(o1.three, o1.five, o1.seven);
                long value2 = calculate(o2.three, o2.five, o2.seven);
                if (value1 == value2) {
                    return 0;
                }
                return value1 < value2 ? -1: 1;
            }
        });
        boolean[][][] visited = new boolean[k + 1][k + 1][k + 1];
        minHeap.offer(new Element(1, 1, 1));
        visited[1][1][1] = true;
        for (int i = 1; i < k; i++) {
            Element cur = minHeap.poll();
            if (!visited[cur.three + 1][cur.five][cur.seven]) {
                minHeap.offer(new Element(cur.three + 1, cur.five, cur.seven));
                visited[cur.three + 1][cur.five][cur.seven] = true;
            }
            if (!visited[cur.three][cur.five + 1][cur.seven]) {
                minHeap.offer(new Element(cur.three, cur.five + 1, cur.seven));
                visited[cur.three][cur.five + 1][cur.seven] = true;
            }
            if (!visited[cur.three][cur.five][cur.seven + 1]) {
                minHeap.offer(new Element(cur.three, cur.five, cur.seven + 1));
                visited[cur.three][cur.five][cur.seven + 1] = true;
            }
        }
        Element ans = minHeap.poll();
        return calculate(ans.three, ans.five, ans.seven);
    }

    private long calculate(int three, int five, int seven) {
        long ans = 1;
        for (int i = 1; i <= three; i++) {
            ans *= 3;
        }
        for (int i = 1; i <= five; i++) {
            ans *= 5;
        }
        for (int i = 1; i <= seven; i++) {
            ans *= 7;
        }
        return ans;
    }
}
**/