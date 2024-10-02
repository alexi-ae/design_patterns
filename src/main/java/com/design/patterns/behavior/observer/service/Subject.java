package com.design.patterns.behavior.observer.service;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<ObserverAbs> observers = new ArrayList<>();
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        notifyAllObservers();
    }

    public void add(ObserverAbs observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        observers.forEach(x -> x.update());
    }
}
