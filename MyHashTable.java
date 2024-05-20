
public class MyHashTable<K,V> {
    private class HashNode<K,V> {
        private K key;
        private V value;
        private HashNode<K,V> next;
        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }
    private HashNode<K,V>[] chainArray;
    private static int M = 11;
    private int size;
    public MyHashTable() {
        this(M);
    }
    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hashCode(K key) {
        int result = 0;
        String keyStr = key.toString();
        for (int i = 0; i < keyStr.length(); i++) {
            result += keyStr.charAt(i);
        }
        return result % M;
    }
    public void put(K key, V value) {
        int index = hashCode(key);
        HashNode<K,V> newN = new HashNode<>(key, value);

        if(chainArray[index] == null) {
            chainArray[index] = newN;
        } else {
            HashNode<K,V> current = chainArray[index];
            while(current.next != null) {
                if(current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newN;
        }
        size++;
    }
    public V get(K key) {
        int index = hashCode(key);
        HashNode<K,V> current = chainArray[index];
        while (current != null) {
            if(current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
    public V remove(K key) {
        int ind = hashCode(key);
        HashNode<K,V> current = chainArray[ind];
        HashNode<K,V> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    chainArray[ind] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.value;
            }
            previous = current;
            current = current.next;
        }

        return null;
    }
    public K getKey(V value) {
        for(HashNode<K,V> node: chainArray) {
            if(node.value.equals(value)) {
                return node.key;
            }
        }
        return null;
    }
    public boolean contains(V value) {
        for(HashNode<K,V> node: chainArray) {
            if(node.value.equals(value)) {
                return true;
            }
        }
        return false;
    }

}