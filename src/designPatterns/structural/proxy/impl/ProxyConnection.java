package designPatterns.structural.proxy.impl;

import GFG.sorting.Utils;
import designPatterns.structural.proxy.DbConnection;

import java.util.Objects;

public class ProxyConnection implements DbConnection {

    private DbConnection con;
    private long createdAt = System.currentTimeMillis();

    @Override
    public String getData() {
        if(Objects.isNull(con)) {
            synchronized (this) {
                Utils.print("Initializing the connection");
                // additional check to prevent race conditon
                con = Objects.isNull(con) ? new RealConnection() : con;
                // say connection initialization takes time.
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return "I'm the proxy we are talking about :) and created at " + createdAt + "\n" + con.getData();
    }
}
