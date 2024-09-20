package com.design.patterns.structural.adapter.service.impl;

public class ExternalPayment {

  public void process(double amount) {
    System.out.println("Pago procesado de: " + amount);
  }
}
