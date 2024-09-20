package com.design.patterns.behavior.strategy;

import com.design.patterns.behavior.strategy.service.impl.DepositServiceImpl;
import com.design.patterns.behavior.strategy.service.impl.WithdrawalServiceImpl;

public class StrategyApp {

  public static void main(String[] args) {
    TransactionProcess transactionProcess = new TransactionProcess();
    // init strategy
    transactionProcess.setStrategy(new DepositServiceImpl());
    transactionProcess.doTransaction(500.00);

    // change strategy
    transactionProcess.setStrategy(new WithdrawalServiceImpl());
    transactionProcess.doTransaction(300.00);
  }
}
