package com.design.patterns.creational.abstractfactory.service;

public interface AccountService {

  double getBalance();

  void deposit(double amount);

  void withdraw(double amount);
}
