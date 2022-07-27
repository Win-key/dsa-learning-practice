package GFG.hashing.openaddressing;

import GFG.hashing.openaddressing.impl.LinearOpenAddressing;

public class Main {

    public static void main(String[] args) {
        Hash hash = new LinearOpenAddressing(4);
        hash.insert(100);
        hash.insert(10);
        hash.insert(1);

        int s = hash.search(10);
        System.out.println("search for 10 = " + s);

        hash.delete(10);

        s = hash.search(10);
        System.out.println("search for 10 after delete= " + s);

        hash.print();
        System.out.println("insert for 10 again ");
        System.out.println("insert for 10 again ");
        hash.insert(10);
        hash.print();

        System.out.println("insert for 5 " + hash.insert(5));
        System.out.println("insert for 8 " + hash.insert(8));

    }

}
