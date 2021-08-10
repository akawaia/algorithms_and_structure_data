package FourthHomeWork;

public class Deque<E>  {
    private final TwoSideLinkedList<E> data;

    public Deque() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    public void insertLast (E value){
        data.insertLast(value);
    }

    public void insertFirst(E value){
        data.insertFirst(value);
    }

    public E removeFirst() {
        return data.removeFirst();
    }

    public E removeLast() {
        return data.removeLast();
    }

    public E peek() {
        return data.getFirst();
    }


    public int size() {
        return data.size();
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }


    public boolean isFull() {
        return false;
    }


    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedQueueImpl{" + "data=" + data + '}';
    }
}
