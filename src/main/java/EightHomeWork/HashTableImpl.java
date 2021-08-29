package EightHomeWork;

import java.util.LinkedList;
import java.util.List;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    static class Item<K, V> implements Entry<K, V> {

        private final K key;
        private V value;
        private Item<K, V> nextItem = null;
        private List<Item<K, V>> list = new LinkedList<>();

        public Item(K key, V value) {
            this.key = key;
            this.value = value;

        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }

        public Item<K, V> getNextItem() {
            return nextItem;
        }

        public void setNextItem(Item<K, V> nextItem) {
            this.nextItem = nextItem;
        }

        public List<Item<K, V>> getList() {
            return list;
        }

        public void setItemInList(Item<K, V> item) {
            this.list.add(item);
        }
    }

    private final Item<K, V> emptyItem = new Item<>(null, null);

    private final Item<K, V>[] data;

    private int size;


    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
    }

    private int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }
        int count = 0;
        int index = hashFunc(key);

        while (data[index] != null) {
            if (isKeysEqual(data[index], key)) {
                data[index].setValue(value);
            }
            if (count > data.length * 2) {
                if (data[index].getNextItem() == null) {
                    data[index].setNextItem(new Item<>(key, value));
                    data[index].setItemInList(data[index].getNextItem());
                    return true;
                } else if (data[index].getNextItem() != null) {
                    for (int i = 0; i < getList(index).size(); i++) {
                        if (getList(index).get(i).getNextItem() == null) {
                            getList(index).get(i).setNextItem(new Item<>(key, value));
                            getList(index).add(getList(index).get(i).getNextItem());
                            return true;
                        }
                    }
                }
            }
            index += getStep(key);
            index %= data.length;
            count++;
        }

        data[index] = new Item<>(key, value);
        return false;
    }

    private List<Item<K, V>> getList(int index) {
        return data[index].getList();

    }

    protected int getStep(K key) {
        return 1;
    }

    private boolean isKeysEqual(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return item.getKey() == null ? key == null : item.getKey().equals(key);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        return index == -1 ? null : data[index].getValue();
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            Item<K, V> item = data[index];
            if (item == null) {
                break;
            } else if (isKeysEqual(item, key)) {
                return index;
            }

            count++;
            index += getStep(key);
            index %= data.length;
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);

        if (index == -1) {
            return null;
        }

        Item<K, V> tempItem = data[index];
        data[index] = emptyItem;
        size--;

        return tempItem.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d = [%s]%n", i, data[i]/*, getList(i)*/);
            if (data[i] == null || data[i].getList() == null) {
                System.out.println("List is null");
            }else System.out.println("List: " + data[i].getList());
        }
        System.out.println("----------------------");
    }
}
