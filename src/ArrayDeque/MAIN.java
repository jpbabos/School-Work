package ArrayDeque;

public class MAIN {
    public static void main(String[] args) {

        Deque DEQUE = new Deque(10);

        DEQUE.insertRight(2);
        DEQUE.display();
        DEQUE.insertLeft(4);
        DEQUE.display();
        DEQUE.insertLeft(6);
        DEQUE.display();
        System.out.println("The last number in the deque is: " + DEQUE.peekRight());
        DEQUE.insertLeft(8);
        DEQUE.display();
        DEQUE.insertRight(10);
        DEQUE.display();
        System.out.println("The first number in the deque is: " + DEQUE.peekLeft());
        DEQUE.insertRight(12);
        DEQUE.display();
        DEQUE.removeRight();
        DEQUE.display();
        DEQUE.removeRight();
        DEQUE.display();
        System.out.println("The last number in the deque is: " + DEQUE.peekRight());
        DEQUE.removeLeft();
        DEQUE.display();
        System.out.println("The first number in the deque is: " + DEQUE.peekLeft());
        DEQUE.removeLeft();
        DEQUE.display();

        System.out.println("Implementation of a Stack using a Deque:");

        Stack STACK = new Stack(4);
        System.out.println("The Stack is empty: " + STACK.isEmpty());
        System.out.println("The stack is full: " + STACK.isFull());
        STACK.push(2);
        STACK.push(4);
        STACK.display();
        System.out.println("The top number is: " + STACK.peek());
        STACK.push(6);
        STACK.push(8);
        STACK.display();
        System.out.println("The top number is: " + STACK.peek());
        System.out.println("The Stack is empty: " + STACK.isEmpty());
        System.out.println("The stack is full: " + STACK.isFull());
        STACK.pop();
        STACK.display();
        System.out.println(" ");
    }
}
