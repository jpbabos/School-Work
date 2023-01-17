package ArrayDeque;

public class Deque {
    private int max;
    private int[] deque;
    private int numOfItems;
    private int left;
    private int right;
    public Deque(int s) {
        max = s;
        deque = new int[max];
        numOfItems = 0;
        left = 1;
        right = 0;
    }
    public int peekLeft() {
        return deque[left];
    }
    public int peekRight() {
        return deque[right];
    }
    public void insertLeft(int value) {
        if(!isFull()) {
            left--;
            if(left < 0) left = max -1;
            deque[left] = value;
            numOfItems++;
        } else System.out.println("The deque is full!");
    }
    public int removeLeft() {
        if(!isEmpty()) {
            int temp = deque[left];
            left++;
            if(left >= max) left = 0;
            numOfItems--;
            return temp;
        } else {
            System.out.println("The deque is empty!");
            return -1;
        }
    }
    public void insertRight(int value) {
        if(!isFull()) {
            right++;
            if(right >= max) right = 0;
            deque[right] = value;
            numOfItems++;
        } else System.out.println("The deque is full!");
    }
    public int removeRight() {
        if(!isEmpty()){
            int temp = deque[right];
            right--;
            if(right < 0) right = max -1;
            numOfItems--;
            return temp;
        } else {
            System.out.println("The deque is empty!");
            return -1;
        }
    }
    public Boolean isEmpty() {
        if(numOfItems == 0) return true;
        else return false;
    }
    public Boolean isFull() {
        if(numOfItems == max) return true;
        else return false;
    }
    public void display() {
        int index = left;
        for(int i = 0; i < numOfItems; i++) {
            if(index >= max) index = 0;
            System.out.print(deque[index] + " ");
            index++;
        }
        System.out.println("");
    }
}