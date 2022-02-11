package archived.ds.map;

import java.util.ArrayList;
import java.util.Objects;

public class HashMap <K,V> {
    private ArrayList<HashNode <K,V>> hashNodes;
    private int size;
    private int buckets = 10;
    private final double loadFactor = .75;

    public HashMap(int buckets) {
        this.buckets = buckets;
        hashNodes = getBucketList();
    }

    public HashMap() {
        hashNodes = getBucketList();
    }

    public V get(K key) {
        int hashIndex = findHashIndex(key);
        HashNode<K, V> headNode = hashNodes.get(hashIndex);
        while(Objects.nonNull(headNode)) {
            if(headNode.getKey().equals(key)) {
                // Key found in Hash, update the value
                return headNode.getValue();
            }
            headNode = headNode.getNext();
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hashIndex = findHashIndex(key);
        HashNode<K, V> headNode = hashNodes.get(hashIndex);
        while(Objects.nonNull(headNode)) {
            if(headNode.getKey().equals(key)) {
                // Key found in Hash, update the value
                return true;
            }
            headNode = headNode.getNext();
        }
        return false;
    }

    public void put(K key, V value) {
        // find hash index
        int hashIndex = findHashIndex(key);
        // check if key already there
        HashNode<K,V> headNode = hashNodes.get(hashIndex);
        // insert/update the key value
        HashNode<K,V> tempNode = headNode;
        while (Objects.nonNull(tempNode)) {
            if(tempNode.getKey().equals(key)) {
                // Key found in Hash, update the value
                tempNode.setValue(value);
                return;
            }
            tempNode = tempNode.getNext();
        }

        HashNode<K,V> newNode = new HashNode<>(key, value);
        if(Objects.nonNull(headNode)) {
            newNode.setNext(headNode);
        }
        hashNodes.set(hashIndex, newNode);
        size++;
        // resize the hashMap for 0.75 load factor
        double currentLF = (double) size / buckets;
        if (currentLF > loadFactor) {
            buckets *= 2;
//            System.out.println("Resizing the hash table : current load factor = " + currentLF + ", buckets = " + buckets);
            ArrayList<HashNode <K,V>> tempNodeList = hashNodes;
            hashNodes = getBucketList();
            size = 0;
            for (HashNode<K, V> hashNode : tempNodeList) {
                while (Objects.nonNull(hashNode)) {
                    this.put(hashNode.getKey(), hashNode.getValue());
                    hashNode = hashNode.getNext();
                }
            }
        }
    }

    public V remove(K key) {
        int hashIndex = findHashIndex(key);
        HashNode<K, V> headNode = hashNodes.get(hashIndex);
        HashNode<K, V> prevNode = null;
        while(Objects.nonNull(headNode)) {
            if(headNode.getKey().equals(key)) {
                // Key found in Hash
                V removed = headNode.getValue();
                // Check, if curr node is head
                if(Objects.nonNull(prevNode)) {
                    prevNode.setNext(headNode.getNext());
                }else {
                    // if node to be deleted is head, then next node should be moved to head
                    hashNodes.set(hashIndex, headNode.getNext());
                }
                // curr node completely de-referred
                headNode.setNext(null);
                return removed;
            }
            prevNode = headNode;
            headNode = headNode.getNext();
        }
        return null;
    }

    private ArrayList<HashNode<K, V>> getBucketList() {
        ArrayList<HashNode<K, V>> bucketList = new ArrayList<>(buckets);
        for (int i = 0; i < buckets; i++) {
            bucketList.add(null);
        }
        return bucketList;
    }

    private int findHashIndex(K key) {
        return Objects.hashCode(key) % buckets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (HashNode<K, V> hashNode : hashNodes) {
            while (Objects.nonNull(hashNode)) {
                sb.append(hashNode).append(",");
                hashNode = hashNode.getNext();
            }
        }
        sb.setLength(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
