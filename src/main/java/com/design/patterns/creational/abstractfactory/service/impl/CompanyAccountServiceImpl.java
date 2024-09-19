package com.design.patterns.creational.abstractfactory.service.impl;

import com.design.patterns.creational.abstractfactory.service.AccountService;

public class CompanyAccountServiceImpl implements AccountService {

  private double balance;

  public CompanyAccountServiceImpl() {
    this.balance = 0.0;
  }

  @Override
  public double getBalance() {
    return balance;
  }

  @Override
  public void deposit(double amount) {
    balance += amount;
    System.out.println("Depósito de " + balance + " realizado en la Cuenta Empresarial.");
  }

  @Override
  public void withdraw(double amount) {
    if (balance <= amount) {
      System.out.println("Fondos insuficientes en la Cuenta Empresarial.");
    }
    balance -= amount;
    System.out.println("Retiro de " + balance + " realizado de la Cuenta Empresarial.");

  }
}
