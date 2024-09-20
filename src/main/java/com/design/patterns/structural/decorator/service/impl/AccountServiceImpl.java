package com.design.patterns.structural.decorator.service.impl;

import com.design.patterns.structural.decorator.service.AccountService;

public class AccountServiceImpl implements AccountService {

  private double balance;

  public AccountServiceImpl() {
    this.balance = 0.0;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
    System.out.println("Depositado: " + amount + ". Saldo actual: " + balance);
  }

  @Override
  public void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      System.out.println("Retirado: " + amount + ". Saldo actual: " + balance);
    } else {
      System.out.println("Saldo insuficiente para retirar " + amount);
    }
  }

  @Override
  public double getBalance() {
    return balance;
  }
}
