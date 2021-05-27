package Y2021.ds.map;

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

    public void put(K key, V value) {
        if(Objects.isNull(key)) {
            throw new IllegalArgumentException("Key could not be Null");
        }
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
            System.out.println("Resizing the hash table : current load factor = " + currentLF + ", buckets = " + buckets);
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
