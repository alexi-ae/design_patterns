package com.design.patterns.behavior.memento.model;

public class Transaction {

  private String type;
  private double balance;

  public Transaction(String type, double balance) {
    this.type = type;
    this.balance = balance;
  }

  public String getType() {
    return type;
  }

  public double getBalance() {
    return balance;
  }
}
