package com.design.patterns.creational.singleton;

import java.util.Objects;

public class Connection {

    private static Connection instance;

    // privado para evitar instancias por new
    private Connection() {
    }

    public static Connection getInstance() {
        if (Objects.isNull(instance))
            instance = new Connection();
        return instance;
    }

    public void connect() {
        System.out.println("Connect to DB");
    }

    public void disconnect() {
        System.out.println("Disconnect to DB");
    }

}
