package FourthHomeWork;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Node<E> firstElement;
    protected int size;
    protected Node<E> current = firstElement;
    protected Node<E> previous = null;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = firstElement;
        firstElement = removedNode.next;
        removedNode.next = null;

        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        } else if(current == firstElement) {
            removeFirst();
            return true;
        } else {
            previous.next = current.next;
        }

        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = firstElement;
        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }

            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public E getFirst() {
        return getValue(firstElement);
    }

    protected E getValue(Node<E> value) {
        return value != null ? value.item : null;
    }

    public E removeLast() {
        Node<E> value = null;
        Node<E> current = firstElement;
        while (current != null) {
            if (current.next.equals(null)) {
                value = current;
                break;
            }
            current = current.next;
        }
        if (isEmpty()) {
            return null;
        }
        remove(value.item);
        return value.item;
    }


    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public void remove() {
            removeLast();
        }

        @Override
        public E next() {
            return current.next.item;
        }
    }
}
