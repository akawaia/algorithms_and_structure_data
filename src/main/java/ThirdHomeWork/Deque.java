package ThirdHomeWork;

public interface Deque {
    void insertLeft(int i);

    void insertRight(int i);

    int removeLeft();

    int removeRight();

    int peek();

    boolean isFull();

    boolean isEmpty();

    int size();
}
