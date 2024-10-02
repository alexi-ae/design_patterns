package com.design.patterns.behavior.observer;

import com.design.patterns.behavior.observer.service.Subject;
import com.design.patterns.behavior.observer.service.impl.PesoArgObserver;
import com.design.patterns.behavior.observer.service.impl.PesoMexObserver;
import com.design.patterns.behavior.observer.service.impl.SolPerObserver;

public class ObserverApp {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new SolPerObserver(subject);
        new PesoArgObserver(subject);
        new PesoMexObserver(subject);
        System.out.println("Si desea cambiar 10 d�lares obtendr� : ");
        subject.setAmount(10.0);
        System.out.println("-----------------");
        System.out.println("Si desea cambiar 100 d�lares obtendr� : ");
        subject.setAmount(100.0);
    }
}
