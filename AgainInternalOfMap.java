import java.util.LinkedList;

public class AgainInternalOfMap {
    public static void main(String[] args) {
        NotHashMap<String, Integer> map = new NotHashMap<>();

        map.put("Alice", 25);
        map.put("Bob", 30);

        System.out.println("Alice's age: " + map.get("Alice"));
        System.out.println("Contains 'Bob': " + map.containsKey("Bob"));

        map.remove("Alice");
        System.out.println("Alice's age after removal: " + map.get("Alice"));
    }
}

class NotHashMap<K, V> {
    static class Node<K, V> {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity = 16;
    private LinkedList<Node<K, V>>[] buckets;

    @SuppressWarnings("unchecked")
    public NotHashMap() {
        // Java doesn't allow you to directly create generic arrays (e.g., new
        // LinkedList<K, V>[]) due to type erasure.
        // To bypass this, the code creates a raw array (new LinkedList[capacity]) and
        // suppresses the "unchecked" warning because the type informatin (<K, V>) is
        // lost at runtime.
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int getIndex(K key) {
        // has hash always been integer
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new Node<>(key, value));

    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node);
                return;
            }
        }

        System.out.println("Error");
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];

        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return true;
            }
        }

        return false;
    }
}
