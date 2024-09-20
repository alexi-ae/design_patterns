package com.design.patterns.behavior.strategy;

import com.design.patterns.behavior.strategy.service.TransactionStrategyService;

public class TransactionProcess {

  private TransactionStrategyService transactionStrategyService;

  public void setStrategy(TransactionStrategyService strategy) {
    this.transactionStrategyService = strategy;
  }

  public void doTransaction(double amount) {
    if (transactionStrategyService != null) {
      transactionStrategyService.doTransaction(amount);
    } else {
      System.out.println("No se ha establecido una estrategia de transacción.");
    }
  }
}
