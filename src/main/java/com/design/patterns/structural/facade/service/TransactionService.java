package com.design.patterns.structural.facade.service;

public class TransactionService {

  public void carryOut(String origenAccount, String destinationAccount, double amount) {
    System.out.println(
        "Transacción de " + amount + " desde " + origenAccount + " a " + destinationAccount);
  }
}
