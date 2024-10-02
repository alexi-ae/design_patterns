package com.design.patterns.behavior.memento.model;

import java.util.ArrayList;
import java.util.List;

public class MementoTransaction {

  private double balance;
  private List<Transaction> transactions;

  public MementoTransaction(double balance, List<Transaction> transactions) {
    this.balance = balance;
    this.transactions = new ArrayList<>(transactions);
  }

  public double getBalance() {
    return balance;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
}
