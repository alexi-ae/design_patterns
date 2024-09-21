package com.design.patterns.behavior.command.service.impl;

import com.design.patterns.behavior.command.receiver.Account;
import com.design.patterns.behavior.command.service.IOperation;

public class WithDrawImpl implements IOperation {

  private Account account;
  private double amount;

  public WithDrawImpl(Account account, double amount) {
    this.account = account;
    this.amount = amount;
  }

  @Override
  public void execute() {
    this.account.withdraw(this.amount);
  }
}
