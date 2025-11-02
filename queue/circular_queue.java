class MyCircularQueue {

    private int front;
    private int rear;
    private int[] elements;
    private int size;
    private int count;

    public MyCircularQueue(int k) {
        this.size = k;
        this.count = 0;
        this.front = -1;
        this.rear = 0;
        this.elements = new int[k];
    }

    public boolean enQueue(int value) {
        if (count == size) {
            System.out.println("Full");
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            System.out.println("Empty");
            return false;
        }
        // elements[front+1]=0;
        front = (front + 1) % size;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        if (front == elements.length - 1) {
            return elements[0];
        }
        return elements[front + 1];
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        if (rear == 0) {
            return elements[elements.length - 1];
        }
        return elements[rear - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
