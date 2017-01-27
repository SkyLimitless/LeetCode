package Easy;

import java.util.Stack;

/**
 * Created by Aakash on 1/26/2017.
 */

public class MinStack {
    Stack<Integer> m, n;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        m = new Stack<>();
        n = new Stack<>();
    }

    public void push(int x) {
        if (n.empty() || n.peek() >= x) {
            n.push(x);
        }
        m.push(x);
    }

    public void pop() {
        if (n.peek().equals(m.peek())) {
            n.pop();
        }
        m.pop();
    }

    public int top() {
        if (!m.empty())
            return m.peek();
        else
            return 0;
    }

    public int getMin() {
        if (!n.empty())
            return n.peek();
        else
            return 0;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(512);
        m.push(-1024);
        m.push(-1024);
        m.push(512);
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */