package designPatterns.structural.proxy;

import GFG.sorting.Utils;
import designPatterns.structural.proxy.impl.ProxyConnection;

public class MainClass {

    public static void main(String[] args) {
        DbConnection con = new ProxyConnection();

        // Slow process to set the connection
        Utils.print(con.getData());
        // Data from cached connection
        Utils.print(con.getData());
    }

}
