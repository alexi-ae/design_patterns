package com.design.patterns.creational.singleton;

public class SingletonApp {
    public static void main(String[] args) {
        System.out.println("They are the same instance");
        Connection connection = Connection.getInstance();
        connection.connect();
        connection.disconnect();
        System.out.println(connection);

        Connection otherConnection = Connection.getInstance();
        otherConnection.connect();
        otherConnection.disconnect();
        System.out.println(otherConnection);

        boolean rpta = connection instanceof Connection;
        System.out.println(rpta);
    }
}
