package c04_QueueStack;

import java.util.Deque;
import java.util.LinkedList;
// pop push min top
public class stackwithMin {
    private Deque<Integer> NUM;
    private Deque<Integer> MIN;

    public stackwithMin() {
        NUM = new LinkedList<>();
        MIN = new LinkedList<>();
    }

    public void push(int element) {
        if (MIN.isEmpty() || element <= MIN.peek()) {
            MIN.push(element);
        }
        NUM.push(element);
    }

    public int pop() {
        if (NUM.isEmpty()) {   //NUM.size() == 0
            return -1;
        }
        if (NUM.peek().equals(MIN.peek())) {
            MIN.pop();
        }
        return NUM.pop();
    }

    public int min() {
        if (NUM.isEmpty()) {
            return -1;
        }
        return MIN.peek();
    }

    public int top() {
        if (NUM.isEmpty()) {
            return -1;
        }
        return NUM.peek();
    }
}
