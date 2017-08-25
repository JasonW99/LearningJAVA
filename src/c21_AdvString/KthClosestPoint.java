package c21_AdvString;

import java.util.*;

public class KthClosestPoint {
    public List<Integer> slove(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                int d1 = distance(l1, a, b, c);
                int d2 = distance(l2, a, b, c);
                if (d1 == d2) {
                    return 0;
                }
                return d1 < d2 ? -1 : 1;
            }
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> result = Arrays.asList(0,0,0);
        minHeap.offer(result);
        visited.add(result);
        while (k >= 1) {
            result = minHeap.poll();
            List<Integer> next = Arrays.asList(result.get(0) + 1, result.get(1), result.get(2));
            if (next.get(0) < a.length && visited.add(next)) {
                minHeap.offer(next);
            }
            next = Arrays.asList(result.get(0), result.get(1) + 1, result.get(2));
            if (next.get(1) < b.length && visited.add(next)) {
                minHeap.offer(next);
            }
            next = Arrays.asList(result.get(0), result.get(1), result.get(2) + 1);
            if (next.get(2) < c.length && visited.add(next)) {
                minHeap.offer(next);
            }
            k--;
        }
        return Arrays.asList(a[result.get(0)], b[result.get(1)], c[result.get(2)]);
        // result.set(0, a[result.get(0)]);
        // result.set(1, b[result.get(1)]);
        // result.set(2, c[result.get(2)]);
        // return result;
    }

    private int distance(List<Integer> coordinate, int[] a, int[] b, int[] c) {
        int aD = a[coordinate.get(0)];
        int bD = b[coordinate.get(1)];
        int cD = c[coordinate.get(2)];
        return aD * aD + bD * bD + cD * cD;
    }
}

/**
public class Solution {
    class Element {
        int a;
        int b;
        int c;

        Element(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare (Element o1, Element o2) {
                int dist1 = getDist(o1, a, b, c);
                int dist2 = getDist(o2, a, b, c);
                if (dist1 == dist2) {
                    return 0;
                }
                return dist1 < dist2 ? -1: 1;
            }
        });
        Element cur = new Element(0, 0, 0);
        minHeap.offer(cur);
        boolean[][][] visited = new boolean[k+1][k+1][k+1];
        visited[0][0][0] = true;
        while (k > 0) {
            cur = minHeap.poll();
            k--;
            if (cur.a + 1 < a.length && !visited[cur.a + 1][cur.b][cur.c]) {
                minHeap.offer(new Element(cur.a + 1, cur.b, cur.c));
                visited[cur.a + 1][cur.b][cur.c] = true;
            }
            if (cur.b + 1 < b.length && !visited[cur.a][cur.b + 1][cur.c]) {
                minHeap.offer(new Element(cur.a, cur.b + 1, cur.c));
                visited[cur.a][cur.b + 1][cur.c] = true;
            }
            if (cur.c + 1 < c.length && !visited[cur.a][cur.b][cur.c + 1]) {
                minHeap.offer(new Element(cur.a, cur.b, cur.c + 1));
                visited[cur.a][cur.b][cur.c + 1] = true;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(a[cur.a]);
        result.add(b[cur.b]);
        result.add(c[cur.c]);
        return result;
    }

    private int getDist(Element cur, int[] arraya, int[] arrayb, int[] arrayc) {
        int a = arraya[cur.a];
        int b = arrayb[cur.b];
        int c = arrayc[cur.c];
        return a * a + b * b + c * c;
    }
}
 **/