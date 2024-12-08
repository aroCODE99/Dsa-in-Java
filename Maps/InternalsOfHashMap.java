import java.util.LinkedList;

class MyHashMap<K, V> {

    // Node class for Node
    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int defaultCapacity = 16;
    private LinkedList<Node<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        buckets = new LinkedList[defaultCapacity];
        for (int i = 0; i < defaultCapacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // method to get the index of the bucket
    public int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % defaultCapacity);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);

        // bucket is now a reference to the LinkedList that represents the bucket at the
        // given index.
        LinkedList<Node<K, V>> bucket = buckets[index];

        // if the node already is present
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        // adding the key value to that position in the array
        bucket.add(new Node<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Check if a key exists
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }
        return false;
    }
}

public class InternalsOfHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);

        System.out.println("Alice's age: " + map.get("Alice")); // Output: 25
        System.out.println("Contains 'Bob': " + map.containsKey("Bob")); // Output: true

        map.remove("Alice");
        System.out.println("Alice's age after removal: " + map.get("Alice")); // Output: null
    }
}

// What Does LinkedList<Node<K, V>>[] Add?
// The array ([]) introduces buckets, which are critical for efficiency:

// The array uses the hash value of the key to determine which bucket (linked
// list) a Node<K, V> belongs to.
// Each bucket is a separate LinkedList to handle potential collisions at the
// same hash index.

// Example of Iterating Through the Bucket
// Suppose we have a HashMap that has a bucket with two key-value pairs:

// "key1" -> 100
// "key2" -> 200
// If both keys hash to the same bucket (say, at index 2), then both pairs will
// be stored in the same bucket (a LinkedList).

// Now, if you try to retrieve the value for "key2", here's what happens:

// Hash the key "key2" to get the bucket index (2).
// Access the bucket at index 2 in the buckets array. This bucket contains a
// LinkedList with the two nodes: ("key1", 100) and ("key2", 200).
// Iterate through the bucket to find the matching key ("key2").
// Compare "key2" with the first node ("key1"), but it's not a match.
// Then compare "key2" with the second node ("key2"), which is a match.
// Once the correct key is found, we can return its associated value (e.g., 200
// for "key2").
