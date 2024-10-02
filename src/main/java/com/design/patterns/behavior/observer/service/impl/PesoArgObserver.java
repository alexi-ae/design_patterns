package com.design.patterns.behavior.observer.service.impl;

import com.design.patterns.behavior.observer.service.ObserverAbs;
import com.design.patterns.behavior.observer.service.Subject;

public class PesoArgObserver extends ObserverAbs {

    private double exchangeValue = 29.86;

    public PesoArgObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("ARG: " + (subject.getAmount() * exchangeValue));
    }
}
