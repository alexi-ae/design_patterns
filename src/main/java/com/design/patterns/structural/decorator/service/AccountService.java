package com.design.patterns.structural.decorator.service;

public interface AccountService {

  void deposit(double amount);

  void withdraw(double amount);

  double getBalance();
}
