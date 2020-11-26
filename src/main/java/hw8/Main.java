package hw8;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //цепочками с рехешем

        HashTable<Product, Integer> table = createBigHashTable();
        table.display();
        System.out.println(table.size());
//        testMethods();
    }

    private static HashTable<Product, Integer> createBigHashTable() {
        Random random = new Random();
        HashTable<Product, Integer> table = new HashTableImpl<>();

        for (int i = 0; i < 1000; i++) {
            table.put(new Product(i, "Product #" + (i+1)), random.nextInt(1000));
        }

        return table;
    }

    private static void testMethods() {
        HashTable<Product, Integer> hashTable = new HashTableImpl<>();
        hashTable.put(new Product(1, "Orange"), 150);
        hashTable.put(new Product(77, "Banana"), 100);
        hashTable.put(new Product(77, "Carrot"), 228);
        hashTable.put(new Product(60, "Lemon"), 250);
        hashTable.put(new Product(52, "Milk"), 120);
        hashTable.put(new Product(21, "Potato"), 67);

        System.out.println("Size is " + hashTable.size());
        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));

        hashTable.remove(new Product(21, "Potato"));
        hashTable.remove(new Product(77, "Banana"));

        System.out.println("Cost potato is " + hashTable.get(new Product(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get(new Product(77, "Banana")));

        hashTable.display();
    }
}
