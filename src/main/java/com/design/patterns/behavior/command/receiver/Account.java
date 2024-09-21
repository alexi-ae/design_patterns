package com.design.patterns.behavior.command.receiver;

public class Account {

  private int id;
  private double balance;

  public Account(int id, double balance) {
    this.id = id;
    this.balance = balance;
  }

  public void withdraw(double amount) {
    System.out.println("********************WITHDRAW*************************************");
    System.out.println("[COMMAND WITHDRAW] Account: " + id + " Amount Initial: " + this.balance);
    System.out.println("[COMMAND WITHDRAW] Account: " + id + " WITHDRAW: " + amount);
    this.balance = this.balance - amount;
    System.out.println("[COMMAND WITHDRAW] Account: " + id + " Amount Final: " + this.balance);
  }

  public void deposit(double amount) {
    System.out.println("********************DEPOSIT*************************************");
    System.out.println("[COMMAND DEPOSIT] Account: " + id + " Amount Initial: " + this.balance);
    System.out.println("[COMMAND DEPOSIT] Account: " + id + " Deposit: " + amount);
    this.balance = this.balance + amount;
    System.out.println("[COMMAND DEPOSIT] Account: " + id + " Amount Final: " + this.balance);
  }

}
