package com.design.patterns.structural.adapter.service;

public interface AccountService {

  void deposit(double amount);

  double getBalance();

  void withdraw(double amount);
}
