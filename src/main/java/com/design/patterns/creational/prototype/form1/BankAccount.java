package com.design.patterns.creational.prototype.form1;

public class BankAccount implements Prototype {

  private String owner;
  private String accountType;
  private double balance;

  public BankAccount(String owner, String accountType, double balance) {
    this.owner = owner;
    this.accountType = accountType;
    this.balance = balance;
  }

  @Override
  public Prototype clone() {
    return new BankAccount(this.owner, this.accountType, this.balance);
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
