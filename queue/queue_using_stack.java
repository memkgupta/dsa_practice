class MyQueue {

    private Stack<Integer> stack;

    public MyQueue() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int i = stack.pop();
        push(x);
        stack.push(i);
    }

    public int pop() {
        int value = stack.pop();
        return value;
    }

    public int peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
