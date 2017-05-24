package c04_QueueStack;

import java.util.Deque;
import java.util.LinkedList;

public class queueBY2stack {
    private Deque<Integer> A;
    private Deque<Integer> B;

    public queueBY2stack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public Integer poll() {
        if (this.isEmpty()) { //note that if A is empty, then it cannot 'pop', but can 'peek'.
            return null;
        }
        if (B.isEmpty()) {
            move2B();
        }
        return B.pop();
    }

    public void offer(int element) {
        A.push(element);
    }

    public Integer peek() {
        if (B.isEmpty()) {
            move2B();
        }
        return B.peek();
    }

    public int size() {
        return A.size() + B.size();
    }

    public boolean isEmpty() {
        return A.isEmpty() && B.isEmpty();
    }

    private void move2B() {
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
    }
}
