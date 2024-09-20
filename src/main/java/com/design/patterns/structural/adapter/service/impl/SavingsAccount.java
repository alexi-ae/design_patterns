package com.design.patterns.structural.adapter.service.impl;

import com.design.patterns.structural.adapter.service.AccountService;

public class SavingsAccount implements AccountService {

  private double balance;

  public SavingsAccount() {
    this.balance = 0.0;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
    System.out.println("Depositado: " + amount + ". Saldo actual: " + balance);
  }

  @Override
  public double getBalance() {
    return balance;
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
}
