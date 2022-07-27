package GFG.hashing.openaddressing;

public interface Hash {
    int search(int data);
    boolean insert(int data) throws IllegalStateException;
    boolean delete(int toDelete);
    void print();
}
