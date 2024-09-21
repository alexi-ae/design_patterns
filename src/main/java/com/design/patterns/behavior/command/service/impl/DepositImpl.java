package com.design.patterns.behavior.command.service.impl;

import com.design.patterns.behavior.command.receiver.Account;
import com.design.patterns.behavior.command.service.IOperation;

public class DepositImpl implements IOperation {

  private Account account;
  private double amount;

  public DepositImpl(Account account, double amount) {
    this.account = account;
    this.amount = amount;
  }

  @Override
  public void execute() {
    this.account.deposit(this.amount);
  }
}
