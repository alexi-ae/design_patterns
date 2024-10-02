package com.design.patterns.behavior.memento;

import com.design.patterns.behavior.memento.model.MementoTransaction;
import com.design.patterns.behavior.memento.service.BankAccount;

public class MementoApp {

  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount(10000);
    MementoTransaction mementoTransaction = bankAccount.saveState();

    bankAccount.deposit(1500);
    bankAccount.withdraw(3800);

    bankAccount.restoreState(mementoTransaction);
  }
}
