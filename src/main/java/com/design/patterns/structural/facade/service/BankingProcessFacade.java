package com.design.patterns.structural.facade.service;

public class BankingProcessFacade {

  private AccountService account;
  private TransactionService transaction;
  private NotificationService notification;

  public BankingProcessFacade() {
    this.account = new AccountService();
    this.transaction = new TransactionService();
    this.notification = new NotificationService();
  }

  public void openAccount(String holder, String type, String email) {
    account.create(holder, type);
    notification.send(email, "Su cuenta de " + type + " ha sido creada exitosamente.");
  }

  public void transferFunds(String originAccount, String destinationAccount, double amount,
      String email) {
    transaction.carryOut(originAccount, destinationAccount, amount);
    notification.send(email,
        "Se ha realizado una transferencia de " + amount + " desde " + originAccount + " a "
            + destinationAccount);
  }
}
