package designPatterns.structural.proxy.impl;

import designPatterns.structural.proxy.DbConnection;

/**
 * Reason we put real instead of concrete is that both proxy and real objects are concrete.
 * so not to confure, we use {@link RealConnection} here.
 */
public class RealConnection implements DbConnection {
    private long createdAt;

    public RealConnection() {
        createdAt = System.currentTimeMillis();
    }

    @Override
    public String getData() {
        return "I'm real connection and created at " + createdAt;
    }
}
