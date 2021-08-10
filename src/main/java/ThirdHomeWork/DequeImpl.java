package ThirdHomeWork;

//Я плохо понимаю как это сделать. Не хватает разбора дз на уроках(
public class DequeImpl implements Deque {

    private int maxSize;
    private int[] deque;
    private int front;
    private int rear;
    private int items;

    public DequeImpl(int size) {
        this.maxSize = size;
        this.deque = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    @Override
    public void insertLeft(int i) {
        deque[front++] = i;
        items++;
    }

    @Override
    public void insertRight(int i) {
        if (rear == maxSize - 1) rear = -1;
        deque[++rear] = i;
        items++;
    }

    @Override
    public int removeLeft() {
        int temp = deque[front++];
        if (front == maxSize) front = 0;
        items--;
        return temp;
    }

    @Override
    public int removeRight() {
        return this.deque[this.rear--];
    }

    @Override
    public int peek() {
        return deque[front];
    }

    @Override
    public boolean isFull() {
        return items == maxSize;
    }

    @Override
    public boolean isEmpty() {
        return items == 0;
    }

    @Override
    public int size() {
        return items;
    }
}
