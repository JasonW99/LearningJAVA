package c00_HelloWorld;

import javax.lang.model.util.ElementScanner6;
import java.util.Comparator;
import java.util.PriorityQueue;

public class test2 {
    static class Element {
        int level;
        String name;
        Element(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                return o1.level - o2.level;
            }
        });
        Element e1 = new Element("x1", 1);
        Element e2 = new Element("x2", 2);
        minHeap.offer(e1);
        minHeap.offer(e2);
        System.out.println(minHeap.peek().name);
        e2.level = 0;
//        minHeap.offer(e2);
        System.out.println(minHeap.peek().name);
        System.out.println(minHeap.size());
    }
}
