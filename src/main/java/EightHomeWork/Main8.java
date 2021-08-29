package EightHomeWork;

public class Main8 {

    public static void main(String[] args) {
        HashTable<Product, Integer> hashTable = new DoubleHashTable<>(5);//5 * 2 = 10

        hashTable.put(new Product(1, "Orange"), 150); //1
        hashTable.put(new Product(71, "Banana"), 100); //7
        hashTable.put(new Product(61, "Carrot"), 228); //7 -> 8
        hashTable.put(new Product(61, "Lemon"), 250); //0
        hashTable.put(new Product(51, "Milk"), 120); //1 -> 2
        hashTable.put(new Product(21, "Potato"), 67); //1 -> 2 -> 3

        hashTable.display();
    }
}
