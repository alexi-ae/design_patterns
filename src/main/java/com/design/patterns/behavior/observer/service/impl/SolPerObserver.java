package com.design.patterns.behavior.observer.service.impl;

import com.design.patterns.behavior.observer.service.ObserverAbs;
import com.design.patterns.behavior.observer.service.Subject;

public class SolPerObserver extends ObserverAbs {

    private double exchangeValue = 3.75;

    public SolPerObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println("PEN: " + (subject.getAmount() * exchangeValue));
    }
}
