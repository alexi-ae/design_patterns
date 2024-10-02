package com.design.patterns.behavior.observer.service.impl;

import com.design.patterns.behavior.observer.service.ObserverAbs;
import com.design.patterns.behavior.observer.service.Subject;

public class PesoMexObserver extends ObserverAbs {

    private double exchangeValue = 19.07;

    public PesoMexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("MX: " + (subject.getAmount() * exchangeValue));
    }
}
