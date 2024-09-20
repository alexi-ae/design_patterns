package com.design.patterns.structural.proxy.service.impl;

import com.design.patterns.structural.proxy.service.ConsultAccountService;
import com.design.patterns.structural.proxy.utils.Constants;

public class ConsultAccountServiceImpl implements ConsultAccountService {

  private String client;
  private double balance;

  public ConsultAccountServiceImpl(String client) {
    this.client = client;
    this.balance = Constants.generateAmount();
  }

  @Override
  public void showData() {
    System.out.println("El saldo de " + client + " es: " + balance);
  }

  @Override
  public double getBalance() {
    return balance;
  }
}
