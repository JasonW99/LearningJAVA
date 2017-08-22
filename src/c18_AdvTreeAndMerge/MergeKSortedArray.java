package c18_AdvTreeAndMerge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    private class Element {
        int row;
        int col;
        Element(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[] merge(int[][] arrayOfArrays) {
        int len = 0;
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2) {
                if (arrayOfArrays[e1.row][e1.col] == arrayOfArrays[e2.row][e2.col]) {
                    return 0;
                }
                return arrayOfArrays[e1.row][e1.col] < arrayOfArrays[e2.row][e2.col] ? -1 : 1;
            }
        });

        for (int i = 0; i < arrayOfArrays.length; i++) {
            len += arrayOfArrays[i].length;
            if (0 < arrayOfArrays[i].length) {
                minHeap.offer(new Element(i, 0));
            }
        }
        int[] result = new int[len];
        int i = 0;
        while (!minHeap.isEmpty()) {
            Element curr = minHeap.poll();
            result[i++] = arrayOfArrays[curr.row][curr.col];
            if (curr.col + 1 < arrayOfArrays[curr.row].length) {
                minHeap.offer(new Element(curr.row, curr.col + 1));
            }
        }
        return result;
    }
}




