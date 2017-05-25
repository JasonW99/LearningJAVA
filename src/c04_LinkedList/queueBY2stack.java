package c04_LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class queueBY2stack {
    private Deque<Integer> IN;
    private Deque<Integer> OUT;

    public queueBY2stack() {
        IN = new LinkedList<>();
        OUT = new LinkedList<>();
    }

    public Integer poll() {
        if (this.isEmpty()) { //note that if IN is empty, then it cannot 'pop', but can 'peek'.
            return null;
        }
        if (OUT.isEmpty()) {
            move2OUT();
        }
        return OUT.pop();
    }

    public void offer(int element) {
        IN.push(element);
    }

    public Integer peek() {
        if (OUT.isEmpty()) {
            move2OUT();
        }
        return OUT.peek();
    }

    public int size() {
        return IN.size() + OUT.size();
    }

    public boolean isEmpty() {
        return IN.isEmpty() && OUT.isEmpty();
    }

    private void move2OUT() {
        while (!IN.isEmpty()) {
            OUT.push(IN.pop());
        }
    }
}
