package com.design.patterns.creational.factory.service;

public interface BankAccountService {

  void create(int customerId);

  void block();

  void deposit();

  void withdraw();

}
