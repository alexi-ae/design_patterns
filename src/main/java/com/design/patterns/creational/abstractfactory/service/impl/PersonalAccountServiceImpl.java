package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.AccountService;

public class PersonalAccountServiceImpl implements AccountService {

  private double balance;

  public PersonalAccountServiceImpl() {
    this.balance = 0.0;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
    System.out.println("Depósito de " + balance + " realizado en la Cuenta Individual.");
  }

  @Override
  public void withdraw(double amount) {
    if (balance < amount) {
      System.out.println("Fondos insuficientes en la Cuenta Individual.");
    }
    balance -= amount;
    System.out.println("Retiro de " + balance + " realizado de la Cuenta Individual.");
  }
}
