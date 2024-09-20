package com.design.patterns.behavior.strategy.service.impl;

import com.design.patterns.behavior.strategy.service.TransactionStrategyService;

public class WithdrawalServiceImpl implements TransactionStrategyService {

  @Override
  public void doTransaction(double amount) {
    System.out.println("Withdrawal: " + amount);
  }
}