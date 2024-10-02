package com.design.patterns.behavior.memento.service;

import com.design.patterns.behavior.memento.model.MementoTransaction;
import com.design.patterns.behavior.memento.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

  private double balance;
  private List<Transaction> transactions;

  public BankAccount(double startBalance) {
    this.balance = startBalance;
    this.transactions = new ArrayList<>();
  }

  public void deposit(double amount) {
    balance += amount;
    transactions.add(new Transaction("Depósito", amount));
    System.out.println("Depositado: " + amount + ", Saldo actual: " + balance);
  }

  public void withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      transactions.add(new Transaction("Retiro", amount));
      System.out.println("Retirado: " + amount + ", Saldo actual: " + balance);
    } else {
      System.out.println("Fondos insuficientes para retirar: " + amount);
    }
  }

  public MementoTransaction saveState() {
    return new MementoTransaction(balance, transactions);
  }

  public void restoreState(MementoTransaction memento) {
    this.balance = memento.getBalance();
    this.transactions = memento.getTransactions();
    System.out.println("Estado restaurado, Saldo actual: " + balance);
    System.out.println("Transacciones: ");
    for (Transaction t : transactions) {
      System.out.println(t.getType() + ": " + t.getBalance());
    }
  }
}
