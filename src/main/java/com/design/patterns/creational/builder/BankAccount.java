package com.design.patterns.creational.builder;

public class BankAccount {

  private String holder;
  private String accountType;
  private double balance;
  private double interestRate;

  public BankAccount(BankAccountBuilder builder) {
    this.holder = builder.holder;
    this.accountType = builder.accountType;
    this.balance = builder.balance;
    this.interestRate = builder.interestRate;
  }

  public String getHolder() {
    return holder;
  }

  public String getAccountType() {
    return accountType;
  }

  public double getBalance() {
    return balance;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public static class BankAccountBuilder {

    private String holder;
    private String accountType;
    private double balance;
    private double interestRate;

    public BankAccountBuilder setHolder(String holder) {
      this.holder = holder;
      return this;
    }

    public BankAccountBuilder setAccountType(String accountType) {
      this.accountType = accountType;
      return this;
    }

    public BankAccountBuilder setBalance(double balance) {
      this.balance = balance;
      return this;
    }

    public BankAccountBuilder setInterestRate(double interestRate) {
      this.interestRate = interestRate;
      return this;
    }

    public BankAccount build() {
      return new BankAccount(this);
    }
  }
}
