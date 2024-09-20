package com.design.patterns.creational.builder;

public class BuilderApp {

  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount.BankAccountBuilder()
        .setHolder("Test 1")
        .setAccountType("Savings Account")
        .setBalance(1500.00)
        .setInterestRate(5.0)
        .build();
    System.out.println("Show Account Details");
    System.out.println("Titular: " + bankAccount.getHolder());
    System.out.println("Tipo: " + bankAccount.getAccountType());
    System.out.println("Saldo: " + bankAccount.getBalance());
    System.out.println("Interes:" + bankAccount.getInterestRate() + " %");

    System.out.println("************************************************");

    BankAccount bankAccount2 = new BankAccount.BankAccountBuilder()
        .setHolder("Test 2")
        .setAccountType("Current Account")
        .setBalance(20000.00)
        .setInterestRate(1.0)
        .build();
    System.out.println("Show Account Details");
    System.out.println("Titular: " + bankAccount2.getHolder());
    System.out.println("Tipo: " + bankAccount2.getAccountType());
    System.out.println("Saldo: " + bankAccount2.getBalance());
    System.out.println("Interes:" + bankAccount2.getInterestRate() + " %");
  }

}
