package com.design.patterns.creational.factory.service.impl;

import com.design.patterns.creational.factory.service.BankAccountService;

public class SavingAccountServiceImpl implements BankAccountService {

  @Override
  public void create(int customerId) {
    System.out.println("Start create by customerId: " + customerId);
    System.out.println("End create CurrentAccount");
  }

  @Override
  public void block() {
    System.out.println("Start block");
    System.out.println("End block");
  }

  @Override
  public void deposit() {
    System.out.println("Start deposit");
    System.out.println("End deposit");
  }

  @Override
  public void withdraw() {
    System.out.println("Start withdraw");
    System.out.println("End withdraw");
  }
}
