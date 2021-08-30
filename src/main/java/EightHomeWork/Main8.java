package EightHomeWork;

public class Main8 {

    public static void main(String[] args) {
        HashTable<Product, Integer> hashTable = new DoubleHashTable<>(5);//5 * 2 = 10
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                hashTable.put(new Product(i,"Orange"),100);
            }
        }

        hashTable.display();
    }
}
