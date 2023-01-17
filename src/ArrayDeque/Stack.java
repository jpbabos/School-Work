package ArrayDeque;

public class Stack {
    private Deque stackQueue;
    public Stack(int size) {
        stackQueue = new Deque(size);
    }
    public void push(int value) {
        stackQueue.insertRight(value);
    }
    public int pop() {
        return stackQueue.removeRight();
    }
    public int peek() {
        return stackQueue.peekRight();
    }
    public Boolean isEmpty() {
        return stackQueue.isEmpty();
    }
    public Boolean isFull() {
        return stackQueue.isFull();
    }
    public void display(){
        stackQueue.display();
    }
}
