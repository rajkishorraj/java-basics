package com.myjavacode.designpattern.creational;

import java.util.ArrayList;
import java.util.List;

public class ObjectPoolPattern {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection conn = null;
        for (int i = 0; i < 6; i++) {
            conn = connectionPool.getConnection();
        }
        if (conn != null) {
            connectionPool.releaseConnection(conn);
        }

        connectionPool.getConnection();

    }

}

abstract class ObjectPool<T> {
    private List<T> available = new ArrayList<>();
    private List<T> inUse = new ArrayList<>();
    private static final int maxConnection = 5;

    public ObjectPool () {
        createAllConnection();
    }

    public void createAllConnection() {
        for (int i = 0; i < maxConnection; i++) {
            available.add(createConnection());
        }

    }
    public abstract T createConnection();

    public synchronized T getConnection() {
        T conn;
        if (available.size() > 0) {
            conn = available.get(available.size() - 1);
            available.remove(conn);
            inUse.add(conn);
        } else {
            throw new RuntimeException("Max connection reached");
        }
        return conn;
    }

    public synchronized void releaseConnection (T t) {
        available.add(t);
        inUse.remove(t);
    }
}

class ConnectionPool extends ObjectPool<Connection> {

    @Override
    public Connection createConnection() {
        return new Connection();
    }
}

class Connection {
    private String name = "name";
    public Connection () {
    }
}
