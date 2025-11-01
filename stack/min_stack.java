class MinStack {

    Node top;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        this.top = null;
    }

    public void push(int val) {
        if (top != null) {
            min = Math.min(top.p.min, val);
        } else {
            min = val;
        }

        Node node = new Node(new Pair(min, val));
        Node prev = top;
        top = node;
        top.prev = prev;
        if (prev != null) {
            prev.next = top;
        }
    }

    public void pop() {
        if (top != null) {
            Node prev = top.prev;
            if (prev != null) {
                prev.next = null;
            }
            top = prev;
        }
    }

    public int top() {
        return top.p.value;
    }

    public int getMin() {
        return top.p.min;
    }
}

class Node {

    Pair p;
    Node next;
    Node prev;

    Node(Pair p) {
        this.p = p;
        this.next = null;
    }
}

class Pair {

    int min;
    int value;

    Pair(int min, int value) {
        this.min = min;
        this.value = value;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
