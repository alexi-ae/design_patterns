package com.design.patterns.creational.prototype.form2;

public class BankAccountOptional implements Cloneable {

  private String owner;
  private String accountType;
  private double balance;

  public BankAccountOptional(String owner, String accountType, double balance) {
    this.owner = owner;
    this.accountType = accountType;
    this.balance = balance;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
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
