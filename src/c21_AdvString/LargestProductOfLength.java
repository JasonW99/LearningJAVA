package c21_AdvString;

import java.util.*;

public class LargestProductOfLength {
    public int solve(String[] dict) {
        Arrays.sort(dict, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) {
                    return 0;
                }
                return s1.length() > s2.length() ? -1 : 1;
            }
        });
        Map<String, Integer> bitMasks = getBitMask(dict);

        int max = 0;
        for (int j = 1; j < dict.length; j++) {
            for (int i = 0; i < j; i++) {
                int prod = dict[i].length() * dict[j].length();
                if (prod <= max) {
                    break; // not continue, think about the reason
                }
                int iMask = bitMasks.get(dict[i]);
                int jMask = bitMasks.get(dict[j]);
                if ((iMask & jMask) == 0) {
                    max = prod;
                    return max;
                }
            }
        }
        return max;
        }

        private Map<String, Integer> getBitMask(String[] dict) {
            Map<String, Integer> bitMasks = new HashMap<>();
            for (String curr : dict) {
                int currMask = 0;
                for (int i = 0; i < curr.length(); i++) {
                    currMask |= (1 << (curr.charAt(i) - 'a'));
                }
                bitMasks.put(curr, currMask);
            }
            return bitMasks;
        }
    }







/**
class Element {
    int first;
    int second;
    Element(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
    public int largestProduct(String[] dict) {
        if (dict == null || dict.length < 2) {
            return 0;
        }
        sort(dict, 0, dict.length-1);
        Element cur = new Element(0, 1);
        PriorityQueue<Element> maxHeap = new PriorityQueue<>(new Comparator<Element>(){
            @Override
            public int compare(Element o1, Element o2) {
                int product1 = dict[o1.first].length() * dict[o1.second].length();
                int product2 = dict[o2.first].length() * dict[o2.second].length();
                if (product1 == product2) {
                    return 0;
                }
                return product1 > product2? -1: 1;
            }
        });
        maxHeap.offer(cur);
        boolean[][] visited = new boolean[dict.length][dict.length];
        visited[0][1] = true;
        while (!maxHeap.isEmpty()) {
            cur = maxHeap.poll();
            if (!dup(dict[cur.first], dict[cur.second])) {
                return dict[cur.first].length() * dict[cur.second].length();
            }
            if (cur.first+1 < cur.second && !visited[cur.first+1][cur.second]) {
                maxHeap.offer(new Element(cur.first+1, cur.second));
                visited[cur.first+1][cur.second] = true;
            }
            if (cur.second+1 < dict.length && !visited[cur.first][cur.second+1]) {
                maxHeap.offer(new Element(cur.first, cur.second+1));
                visited[cur.first][cur.second+1] = true;
            }
        }
        return 0;
    }

    private boolean dup(String one, String two) {
        if (one.length() > two.length()) {
            String temp = one;
            one = two;
            two = temp;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < one.length(); i++) {
            set.add(one.charAt(i));
        }
        for (int i = 0; i < two.length(); i++) {
            if (set.contains(two.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private void sort(String[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        String pivot = array[start];
        int i = start+1;
        int j = end;
        while (i <= j) {
            if (array[i].length() < pivot.length()) {
                swap(array, i, j);
                j--;
            } else {
                i++;
            }
        }
        swap(array, start, j);
        sort(array, start, j-1);
        sort(array, j+1, end);
    }

    private void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
**/